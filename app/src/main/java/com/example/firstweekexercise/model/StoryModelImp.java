package com.example.firstweekexercise.model;

import com.example.firstweekexercise.bean.StoryBannerBean;
import com.example.firstweekexercise.interfaces.ApiService;
import com.example.firstweekexercise.interfaces.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoryModelImp implements StoryModel{
    @Override
    public void getStoryData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.mWanApi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.storyData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryBannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StoryBannerBean storyBannerBean) {
                        callBack.onSuccess(storyBannerBean);
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
