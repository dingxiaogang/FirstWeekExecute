package com.example.secondmidterm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.dbdao.CollectBeanDao;
import com.example.secondmidterm.adapter.RvMainAdapter;
import com.example.secondmidterm.adapter.RvShowAdapter;
import com.example.secondmidterm.bean.CollectBean;
import com.example.secondmidterm.bean.MainBean;
import com.example.secondmidterm.bean.ShowBean;
import com.example.secondmidterm.util.DbUtil;
import com.example.secondmidterm.util.GetOkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ShowActivity extends AppCompatActivity {

    private static final String TAG = "ShowActivity";

    private RecyclerView mShowRv;
    private ArrayList<ShowBean.T1348648756099Bean> mshowBean;
    private RvShowAdapter showAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        showAdapter.setOnClickListener(new RvShowAdapter.onClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(ShowActivity.this,CollectActivity.class);
                startActivity(intent);
            }
        });

        showAdapter.setOnClickListener2(new RvShowAdapter.onClickListener2() {
            @Override
            public void onClick(View view, final int position) {
                AlertDialog alertDialog = new AlertDialog.Builder(ShowActivity.this)
                        .setTitle("请选择")
                        .setMessage("确定为收藏")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                CollectBeanDao collectBeanDao = DbUtil.getDbUtil().getCollectBeanDao();
                                ShowBean.T1348648756099Bean t1348648756099Bean = mshowBean.get(position);
                                CollectBean collectBean = new CollectBean(null, t1348648756099Bean.getImgsrc(), t1348648756099Bean.getTitle(), t1348648756099Bean.getPtime());
                                if (!isHas(collectBean)){
                                    collectBeanDao.insertOrReplace(collectBean);
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
    }

    public boolean isHas(CollectBean collectBean){
        List<CollectBean> list = DbUtil.getDbUtil().getCollectBeanDao().queryBuilder().where(CollectBeanDao.Properties.Title.eq(collectBean.getTitle())).list();
        if (list != null && list.size() > 0){
            return true;
        }
        return false;
    }

    private void initData() {
        OkHttpClient client = GetOkHttp.getClient();
        Request request = new Request.Builder()
                .url("http://c.m.163.com/nc/article/list/T1348648756099/0-20.html")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                ShowBean showBean = gson.fromJson(string, ShowBean.class);

                mshowBean.addAll(showBean.getT1348648756099());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void initView() {
        mShowRv = (RecyclerView) findViewById(R.id.show_rv);

        mshowBean = new ArrayList<>();
        mShowRv.setLayoutManager(new LinearLayoutManager(this));
        mShowRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        showAdapter = new RvShowAdapter(mshowBean);
        mShowRv.setAdapter(showAdapter);
    }
}
