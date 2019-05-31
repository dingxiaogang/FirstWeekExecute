package com.example.firstmidterm.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.firstmidterm.R;
import com.example.firstmidterm.WebViewActivity;
import com.example.firstmidterm.adapter.RvAttentionAdapter;
import com.example.firstmidterm.bean.AttentionBean;
import com.example.firstmidterm.model.AttentionModelImp;
import com.example.firstmidterm.presenter.AttentionPresenterImp;
import com.example.firstmidterm.view.AttentionView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttentionFragment extends Fragment implements AttentionView {

    private static final String TAG = "AttentionFragment";
    private View view;
    private RecyclerView mAttRv;
    private ArrayList<AttentionBean.RecentBean> arrayList;
    private RvAttentionAdapter attentionAdapter;

    public AttentionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_attention, container, false);
        initView(inflate);
        initData();
        initListener();
        return inflate;
    }

    private void initListener() {
        attentionAdapter.setOnClickListener(new RvAttentionAdapter.onClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("link",attentionAdapter.recentBeans.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        AttentionPresenterImp attentionPresenterImp = new AttentionPresenterImp(new AttentionModelImp(),this);
        attentionPresenterImp.getData();
    }

    private void initView(View inflate) {
        mAttRv = (RecyclerView) inflate.findViewById(R.id.att_rv);


        arrayList = new ArrayList<>();
        mAttRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAttRv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        attentionAdapter = new RvAttentionAdapter(arrayList);
        mAttRv.setAdapter(attentionAdapter);
    }

    @Override
    public void onSuccess(AttentionBean attentionBean) {
        arrayList.addAll(attentionBean.getRecent());

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                attentionAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
