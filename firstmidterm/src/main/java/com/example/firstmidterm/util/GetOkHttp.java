package com.example.firstmidterm.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetOkHttp {

    private static OkHttpClient okHttpClient;
    private static Call call;

    public static Call getCall(String url){
        if (okHttpClient == null){
            synchronized (GetOkHttp.class){
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient.Builder()
                            .writeTimeout(20000, TimeUnit.SECONDS)
                            .readTimeout(20000,TimeUnit.SECONDS)
                            .connectTimeout(20000,TimeUnit.SECONDS)
                            .build();

                    Request request = new Request.Builder()
                            .get()
                            .url(url)
                            .build();

                    call = okHttpClient.newCall(request);
                }
            }
        }
        return call;
    }
}
