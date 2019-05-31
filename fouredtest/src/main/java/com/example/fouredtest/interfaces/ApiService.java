package com.example.fouredtest.interfaces;

import com.example.fouredtest.bean.CreationChildBean;
import com.example.fouredtest.bean.CreationTabBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String mWanApi = "http://www.wanandroid.com/";

    //http://www.wanandroid.com/project/tree/json
    @GET("project/tree/json")
    Observable<CreationTabBean> getTabData();

    //http://www.wanandroid.com/project/list/1/json?cid=294
    @GET("project/list/1/json?")
    Observable<CreationChildBean> getData(@Query("cid") int cid);
}
