package com.example.fouredtest.model;
import com.example.fouredtest.bean.CreationChildBean;
import com.example.fouredtest.interfaces.ApiService;
import com.example.fouredtest.interfaces.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreationChildModelImp implements CreationChildModel {
    @Override
    public void getData(int cid, final CallBack<CreationChildBean> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.mWanApi)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ApiService.class).getData(cid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreationChildBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreationChildBean creationChildBean) {
                        callBack.onSuccess(creationChildBean);
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
