package com.example.secondmidterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.secondmidterm.adapter.RvMainAdapter;
import com.example.secondmidterm.bean.MainBean;
import com.example.secondmidterm.model.MainModelImp;
import com.example.secondmidterm.presenter.MainPresenterImp;
import com.example.secondmidterm.view.MainView;

import java.util.ArrayList;

//我是H1810B的丁晓刚 2019-5-30 20:43:21
public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    private RecyclerView mMaRv;
    private ArrayList<MainBean.DataBean.DatasBean> mainBean;
    private RvMainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mainAdapter.setOnClickListener(new RvMainAdapter.onClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        MainPresenterImp mainPresenterImp = new MainPresenterImp(new MainModelImp(),this);
        mainPresenterImp.getData();
    }

    private void initView() {
        mMaRv = (RecyclerView) findViewById(R.id.ma_rv);

        mainBean = new ArrayList<>();
        mMaRv.setLayoutManager(new LinearLayoutManager(this));
        mMaRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mainAdapter = new RvMainAdapter(mainBean);
        mMaRv.setAdapter(mainAdapter);
    }

    @Override
    public void onSuccess(MainBean data) {
        mainBean.addAll(data.getData().getDatas());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
