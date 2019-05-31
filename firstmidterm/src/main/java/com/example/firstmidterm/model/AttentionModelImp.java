package com.example.firstmidterm.model;

import com.example.firstmidterm.bean.AttentionBean;
import com.example.firstmidterm.interfaces.CallBack;
import com.example.firstmidterm.util.GetOkHttp;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AttentionModelImp implements AttentionModel{
    @Override
    public void getData(final CallBack<AttentionBean> callBack) {
        /*GetOkHttp.getCall("http://news-at.zhihu.com/api/4/news/hot").enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                AttentionBean attentionBean = gson.fromJson(string, AttentionBean.class);
                callBack.onSuccess(attentionBean);
            }
        });*/

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/news/hot")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                AttentionBean attentionBean = gson.fromJson(string, AttentionBean.class);
                callBack.onSuccess(attentionBean);
            }
        });
    }
}
