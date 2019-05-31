package com.example.firstweekexercise.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.firstweekexercise.R;
import com.example.firstweekexercise.adapter.GvStoryAdapter;
import com.example.firstweekexercise.adapter.RvStoryListAdapter;
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
public class StoryFragment extends Fragment implements StoryView {

    private static final String TAG = "StoryFragment";

    private View view;
    private Banner mStoryBanner;
    private RecyclerView mStoryGridView;
    private RecyclerView mStoryRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_story, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        StoryPresenterImp storyPresenterImp = new StoryPresenterImp(new StoryModelImp(),this);
        storyPresenterImp.getStoryData();

        ArrayList<Integer> imagePaths = new ArrayList<>();
        imagePaths.add(R.drawable.story_icon_new);
        imagePaths.add(R.drawable.story_icon_morning);
        imagePaths.add(R.drawable.story_icon_sleep);
        imagePaths.add(R.drawable.story_icon_classify);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("最新");
        titles.add("叫早");
        titles.add("哄睡");
        titles.add("全部");
        mStoryGridView.setLayoutManager(new GridLayoutManager(getContext(),4));
        GvStoryAdapter gvStoryAdapter = new GvStoryAdapter(getContext(),imagePaths,titles);
        mStoryGridView.setAdapter(gvStoryAdapter);

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
                        mStoryRv.setLayoutManager(new GridLayoutManager(getContext(),2));
                        RvStoryListAdapter storyListAdapter = new RvStoryListAdapter(getContext(),datasBeans);
                        mStoryRv.setAdapter(storyListAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mStoryBanner = (Banner) inflate.findViewById(R.id.story_banner);
        mStoryGridView = (RecyclerView) inflate.findViewById(R.id.story_gridView);
        mStoryRv = (RecyclerView) inflate.findViewById(R.id.story_rv);
    }

    @Override
    public void onSuccess(StoryBannerBean data) {
        mStoryBanner.setImages(data.getData()).setImageLoader(new ImageLoader() {
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
        Log.d(TAG, "onFail: "+error);
    }
}
