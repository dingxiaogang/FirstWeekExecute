package com.example.secondtest.model;

import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.example.secondtest.bean.ThemeBean;
import com.example.secondtest.interfaces.ApiService;
import com.example.secondtest.interfaces.CallBack;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThemeModelImp implements ThemeModel{
    @Override
    public void getData(final CallBack<ThemeBean> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.mWanApi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getThemeData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ThemeBean themeBean) {
                        callBack.onSuccess(themeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
