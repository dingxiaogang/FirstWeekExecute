package com.example.secondtest.interfaces;

import com.example.secondtest.bean.ThemeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String mWanApi = "http://www.wanandroid.com/";

    //http://www.wanandroid.com/project/list/1/json?cid=294

    @GET("project/list/1/json?cid=294")
    Observable<ThemeBean> getThemeData();
}
