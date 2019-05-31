package com.example.firstweekexercise.interfaces;

import com.example.firstweekexercise.bean.StoryBannerBean;
import com.example.firstweekexercise.bean.StoryListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String mWanApi = "http://www.wanandroid.com/";

    //http://www.wanandroid.com/banner/json
    @GET("banner/json")
    Observable<StoryBannerBean> storyData();

    //http://www.wanandroid.com/project/list/1/json?cid=294
    @GET("project/list/1/json?cid=294")
    Observable<StoryListBean> storyList();
}
