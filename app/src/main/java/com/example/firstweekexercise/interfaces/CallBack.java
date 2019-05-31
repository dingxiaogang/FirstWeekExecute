package com.example.firstweekexercise.interfaces;

import com.example.firstweekexercise.bean.StoryBannerBean;

public interface CallBack {
    void onSuccess(StoryBannerBean data);
    void onFail(String error);
}
