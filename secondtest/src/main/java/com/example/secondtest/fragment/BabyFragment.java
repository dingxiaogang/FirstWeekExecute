package com.example.secondtest.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secondtest.R;
import com.example.secondtest.adapter.RvPlayAdapter;
import com.example.secondtest.adapter.RvPopularAdapter;
import com.example.secondtest.adapter.RvThemeAdapter;
import com.example.secondtest.adapter.VpFindAdapter;
import com.example.secondtest.bean.ThemeBean;
import com.example.secondtest.model.ThemeModelImp;
import com.example.secondtest.presenter.ThemePresenterImp;
import com.example.secondtest.view.ThemeView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyFragment extends Fragment implements ThemeView {

    private static final String TAG = "BabyFragment";
    private View view;
    private RecyclerView mBabyPopularRv;
    private RecyclerView mBabyPlayRv;
    private TabLayout mBabyTabLayout;
    private ViewPager mBabyViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_baby, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        ThemePresenterImp themePresenterImp = new ThemePresenterImp(new ThemeModelImp(),this);
        themePresenterImp.getData();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new LatestFragment());
        fragments.add(new HotFragment());

        ArrayList<Integer> titles = new ArrayList<>();
        titles.add(R.string.latest);
        titles.add(R.string.hot);

        VpFindAdapter findAdapter = new VpFindAdapter(getChildFragmentManager(),getContext(),titles,fragments);
        mBabyViewPager.setAdapter(findAdapter);
        mBabyTabLayout.setupWithViewPager(mBabyViewPager);
    }

    private void initView(View inflate) {
        mBabyPopularRv = (RecyclerView) inflate.findViewById(R.id.baby_popular_rv);
        mBabyPlayRv = (RecyclerView) inflate.findViewById(R.id.baby_play_rv);
        mBabyTabLayout = (TabLayout) inflate.findViewById(R.id.baby_tabLayout);
        mBabyViewPager = (ViewPager) inflate.findViewById(R.id.baby_viewPager);
    }

    @Override
    public void onSuccess(ThemeBean themeBean) {
        ArrayList<ThemeBean.DataBean.DatasBean> themeData = new ArrayList<>();
        themeData.addAll(themeBean.getData().getDatas());

        RvPopularAdapter popularAdapter = new RvPopularAdapter(getContext(),themeData);
        mBabyPopularRv.setAdapter(popularAdapter);
        mBabyPopularRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        RvPlayAdapter playAdapter = new RvPlayAdapter(getContext(),themeData);
        mBabyPlayRv.setAdapter(playAdapter);
        mBabyPlayRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
