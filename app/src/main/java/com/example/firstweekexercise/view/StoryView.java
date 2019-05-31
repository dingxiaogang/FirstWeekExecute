package com.example.firstweekexercise.view;

import com.example.firstweekexercise.bean.StoryBannerBean;

public interface StoryView {
    void onSuccess(StoryBannerBean data);
    void onFail(String error);
}
