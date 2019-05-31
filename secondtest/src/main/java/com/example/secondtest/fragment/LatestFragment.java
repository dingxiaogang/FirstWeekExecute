package com.example.secondtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secondtest.R;
import com.example.secondtest.adapter.RvLatestAdapter;
import com.example.secondtest.adapter.RvPopularAdapter;
import com.example.secondtest.bean.ThemeBean;
import com.example.secondtest.model.ThemeModelImp;
import com.example.secondtest.presenter.ThemePresenterImp;
import com.example.secondtest.view.ThemeView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LatestFragment extends Fragment implements ThemeView {

    private static final String TAG = "LatestFragment";
    private View view;
    private RecyclerView mLatestRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_latest, container, false);
        initData();
        initView(inflate);
        return inflate;
    }

    private void initData() {
        ThemePresenterImp themePresenterImp = new ThemePresenterImp(new ThemeModelImp(), this);
        themePresenterImp.getData();
    }

    @Override
    public void onSuccess(ThemeBean themeBean) {
        ArrayList<ThemeBean.DataBean.DatasBean> themeData = new ArrayList<>();
        themeData.addAll(themeBean.getData().getDatas());

        RvLatestAdapter popularAdapter = new RvLatestAdapter(getContext(), themeData);
        mLatestRv.setAdapter(popularAdapter);
        mLatestRv.setLayoutManager(new GridLayoutManager(getContext(),2));

    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: " + error);
    }

    private void initView(View inflate) {
        mLatestRv = (RecyclerView) inflate.findViewById(R.id.latest_rv);
    }
}
