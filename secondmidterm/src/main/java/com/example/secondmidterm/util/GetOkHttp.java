package com.example.secondmidterm.util;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class GetOkHttp {

    private static OkHttpClient okHttpClient;

    public static OkHttpClient getClient(){
        if (okHttpClient == null){
            synchronized (GetOkHttp.class){
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient.Builder()
                            .writeTimeout(20000, TimeUnit.SECONDS)
                            .readTimeout(20000,TimeUnit.SECONDS)
                            .connectTimeout(20000,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return okHttpClient;
    }
}
