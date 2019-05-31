package com.example.fouredtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.example.fouredtest.R;
import com.example.fouredtest.adapter.RvPreferenceHotAdapter;
import com.example.fouredtest.adapter.RvPreferenceRecommendAdapter;
import com.example.fouredtest.bean.CreationChildBean;
import com.example.fouredtest.model.CreationChildModelImp;
import com.example.fouredtest.presenter.CreationChildPresenterImp;
import com.example.fouredtest.view.CreationChildView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreferenceFragment extends Fragment implements CreationChildView {

    private static final String TAG = "PreferenceFragment";

    private View view;
    private SearchView mPreferenceSearchView;
    private RecyclerView mPreferenceHotRv;
    private RecyclerView mPreferenceRecommendRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_prefercent, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        CreationChildPresenterImp creationChildPresenterImp = new CreationChildPresenterImp(new CreationChildModelImp(),this);
        creationChildPresenterImp.getData(294);
    }

    private void initView(View inflate) {
        mPreferenceSearchView = (SearchView) inflate.findViewById(R.id.preference_searchView);
        mPreferenceHotRv = (RecyclerView) inflate.findViewById(R.id.preference_hot_rv);
        mPreferenceRecommendRv = (RecyclerView) inflate.findViewById(R.id.preference_recommend_rv);
    }

    @Override
    public void onSuccess(CreationChildBean data) {
        List<CreationChildBean.DataBean.DatasBean> datas = data.getData().getDatas();
        RvPreferenceHotAdapter preferenceHotAdapter = new RvPreferenceHotAdapter(datas);
        mPreferenceHotRv.setAdapter(preferenceHotAdapter);
        mPreferenceHotRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        RvPreferenceRecommendAdapter preferenceRecommendAdapter = new RvPreferenceRecommendAdapter(datas);
        mPreferenceRecommendRv.setAdapter(preferenceRecommendAdapter);
        mPreferenceRecommendRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
