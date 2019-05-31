package com.example.secondmidterm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.secondmidterm.adapter.RvCollectAdapter;
import com.example.secondmidterm.bean.CollectBean;
import com.example.secondmidterm.util.DbUtil;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity {

    private RecyclerView mCollRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initView();
        initData();
    }

    private void initData() {
        List<CollectBean> collectBeans = DbUtil.getDbUtil().getCollectBeanDao().loadAll();
        ArrayList<CollectBean> collectBean = new ArrayList<>();
        collectBean.addAll(collectBeans);
        RvCollectAdapter collectAdapter = new RvCollectAdapter(collectBean);
        mCollRv.setAdapter(collectAdapter);
        mCollRv.setLayoutManager(new LinearLayoutManager(this));
        mCollRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void initView() {
        mCollRv = (RecyclerView) findViewById(R.id.coll_rv);
    }
}
