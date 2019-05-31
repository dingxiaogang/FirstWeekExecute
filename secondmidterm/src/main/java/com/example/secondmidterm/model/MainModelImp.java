package com.example.secondmidterm.model;

import com.example.secondmidterm.bean.MainBean;
import com.example.secondmidterm.interfaces.CallBack;
import com.example.secondmidterm.util.GetOkHttp;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainModelImp implements MainModel{
    @Override
    public void getData(final CallBack<MainBean> callBack) {
        OkHttpClient client = GetOkHttp.getClient();
        Request request = new Request.Builder()
                .url("http://www.wanandroid.com/article/list/0/json?cid=294")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                MainBean mainBean = gson.fromJson(string, MainBean.class);
                callBack.onSuccess(mainBean);
            }
        });
    }
}
