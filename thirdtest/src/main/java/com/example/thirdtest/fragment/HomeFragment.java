package com.example.thirdtest.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thirdtest.R;
import com.example.thirdtest.adapter.RvHomeDreamAdapter;
import com.example.thirdtest.adapter.RvHomeFindAdapter;
import com.example.thirdtest.adapter.RvHomeWeekAdapter;
import com.example.thirdtest.bean.CreationChildBean;
import com.example.thirdtest.model.CreationChildModelImp;
import com.example.thirdtest.presenter.CreationChildPresenterImp;
import com.example.thirdtest.view.CreationChildView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements CreationChildView {

    private static final String TAG = "HomeFragment";
    private View view;
    private TextView mBeijing;
    private SearchView mHomeSearchView;
    private Banner mHomeBanner;
    private RecyclerView mHomeDreamsRv;
    private RecyclerView mHomeWeekRv;
    private RecyclerView mHomeInfoRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        final ArrayList<String> banner = new ArrayList<>();
        banner.add("https://www.wanandroid.com/blogimgs/ab17e8f9-6b79-450b-8079-0f2287eb6f0f.png");
        banner.add("https://www.wanandroid.com/blogimgs/fb0ea461-e00a-482b-814f-4faca5761427.png");
        banner.add("https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png");
        mHomeBanner.setImages(banner).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(context).load(path).into(imageView);
            }
        }).start();

        ArrayList<Integer> dreamsPath = new ArrayList<>();
        dreamsPath.add(R.drawable.icon_friend);
        dreamsPath.add(R.drawable.icon_friend);
        dreamsPath.add(R.drawable.icon_friend);
        dreamsPath.add(R.drawable.icon_friend);
        dreamsPath.add(R.drawable.icon_friend);
        dreamsPath.add(R.drawable.icon_friend);
        dreamsPath.add(R.drawable.icon_friend);
        dreamsPath.add(R.drawable.icon_friend);
        ArrayList<String> dreamsTitle = new ArrayList<>();
        dreamsTitle.add("自由行");
        dreamsTitle.add("机票");
        dreamsTitle.add("签证");
        dreamsTitle.add("目的地参团");
        dreamsTitle.add("半自由行");
        dreamsTitle.add("酒店");
        dreamsTitle.add("门票");
        dreamsTitle.add("其他");

        RvHomeDreamAdapter homeDreamAdapter = new RvHomeDreamAdapter(dreamsPath,dreamsTitle);
        mHomeDreamsRv.setLayoutManager(new GridLayoutManager(getContext(),4));
        mHomeDreamsRv.setAdapter(homeDreamAdapter);

        CreationChildPresenterImp creationChildPresenterImp = new CreationChildPresenterImp(new CreationChildModelImp(),this);
        creationChildPresenterImp.getData(294);
    }


    private void initView(View inflate) {
        mBeijing = (TextView) inflate.findViewById(R.id.beijing);
        mHomeSearchView = (SearchView) inflate.findViewById(R.id.home_searchView);
        mHomeBanner = (Banner) inflate.findViewById(R.id.home_banner);
        mHomeDreamsRv = (RecyclerView) inflate.findViewById(R.id.home_dreams_rv);
        mHomeWeekRv = (RecyclerView) inflate.findViewById(R.id.home_week_rv);
        mHomeInfoRv = (RecyclerView) inflate.findViewById(R.id.home_info_rv);
    }

    @Override
    public void onSuccess(CreationChildBean data) {
        RvHomeWeekAdapter homeWeekAdapter = new RvHomeWeekAdapter(data.getData().getDatas());
        mHomeWeekRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        mHomeWeekRv.setAdapter(homeWeekAdapter);

        RvHomeFindAdapter homeFindAdapter = new RvHomeFindAdapter(data.getData().getDatas());
        mHomeInfoRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        mHomeInfoRv.setAdapter(homeFindAdapter);
        mHomeInfoRv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
