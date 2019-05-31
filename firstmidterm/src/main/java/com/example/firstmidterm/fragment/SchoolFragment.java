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

import com.example.firstmidterm.R;
import com.example.firstmidterm.WebViewActivity;
import com.example.firstmidterm.adapter.RvAttentionAdapter;
import com.example.firstmidterm.adapter.RvSchoolAdapter;
import com.example.firstmidterm.bean.AttentionBean;
import com.example.firstmidterm.bean.SchoolBean;
import com.example.firstmidterm.util.GetOkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment {

    private static final String TAG = "SchoolFragment";
    private View view;
    private RecyclerView mSchRv;
    private ArrayList<SchoolBean.NewslistBean> arrayList;
    private RvSchoolAdapter schoolAdapter;

    public SchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_school, container, false);
        initView(inflate);
        initData();
        initListener();
        return inflate;
    }

    private void initListener() {
        schoolAdapter.setOnClickListener(new RvSchoolAdapter.onClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("link",schoolAdapter.newslistBeans.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        GetOkHttp.getCall("http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1").enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                SchoolBean schoolBean = gson.fromJson(string, SchoolBean.class);
                List<SchoolBean.NewslistBean> newslist = schoolBean.getNewslist();

                arrayList.addAll(newslist);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        schoolAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void initView(View inflate) {
        mSchRv = (RecyclerView) inflate.findViewById(R.id.sch_rv);

        arrayList = new ArrayList<>();
        mSchRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mSchRv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        schoolAdapter = new RvSchoolAdapter(arrayList);
        mSchRv.setAdapter(schoolAdapter);
    }
}
