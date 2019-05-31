package com.example.secondtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secondtest.R;
import com.example.secondtest.adapter.RvLatestAdapter;
import com.example.secondtest.bean.ThemeBean;
import com.example.secondtest.model.ThemeModelImp;
import com.example.secondtest.presenter.ThemePresenterImp;
import com.example.secondtest.view.ThemeView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment implements ThemeView {

    private static final String TAG = "HotFragment";

    private View view;
    private RecyclerView mHotRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        ThemePresenterImp themePresenterImp = new ThemePresenterImp(new ThemeModelImp(), this);
        themePresenterImp.getData();
    }

    private void initView(View inflate) {
        mHotRv = (RecyclerView) inflate.findViewById(R.id.hot_rv);
    }

    @Override
    public void onSuccess(ThemeBean themeBean) {
        ArrayList<ThemeBean.DataBean.DatasBean> themeData = new ArrayList<>();
        themeData.addAll(themeBean.getData().getDatas());

        RvLatestAdapter popularAdapter = new RvLatestAdapter(getContext(), themeData);
        mHotRv.setAdapter(popularAdapter);
        mHotRv.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
