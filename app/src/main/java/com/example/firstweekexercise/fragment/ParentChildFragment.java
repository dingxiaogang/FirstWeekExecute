package com.example.firstweekexercise.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.firstweekexercise.R;
import com.example.firstweekexercise.adapter.RvParentListAdapter;
import com.example.firstweekexercise.bean.StoryBannerBean;
import com.example.firstweekexercise.bean.StoryListBean;
import com.example.firstweekexercise.interfaces.ApiService;
import com.example.firstweekexercise.model.StoryModelImp;
import com.example.firstweekexercise.presenter.StoryPresenterImp;
import com.example.firstweekexercise.view.StoryView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParentChildFragment extends Fragment implements StoryView {

    private static final String TAG = "ParentChildFragment";

    private View view;
    private Banner mParentBanner;
    private RecyclerView mParentRv;
    private RecyclerView mParentRv2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_parent_child, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        StoryPresenterImp storyPresenterImp = new StoryPresenterImp(new StoryModelImp(), this);
        storyPresenterImp.getStoryData();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.mWanApi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.storyList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StoryListBean storyListBean) {
                        ArrayList<StoryListBean.DataBean.DatasBean> datasBeans = new ArrayList<>();
                        datasBeans.addAll(storyListBean.getData().getDatas());
                        mParentRv.setLayoutManager(new LinearLayoutManager(getContext()));
                        RvParentListAdapter storyListAdapter = new RvParentListAdapter(getContext(), datasBeans);
                        mParentRv.setAdapter(storyListAdapter);
                        mParentRv2.setLayoutManager(new LinearLayoutManager(getContext()));
                        mParentRv2.setAdapter(storyListAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mParentBanner = (Banner) inflate.findViewById(R.id.parent_banner);
        mParentRv = (RecyclerView) inflate.findViewById(R.id.parent_rv);
        mParentRv2 = (RecyclerView) inflate.findViewById(R.id.parent_rv2);
    }

    @Override
    public void onSuccess(StoryBannerBean data) {
        mParentBanner.setImages(data.getData()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                StoryBannerBean.DataBean storyBannerBean = (StoryBannerBean.DataBean) path;
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(getContext()).load(storyBannerBean.getImagePath()).into(imageView);
            }
        }).start();
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: " + error);
    }
}
