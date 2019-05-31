package com.example.firstweekexercise.presenter;

import com.example.firstweekexercise.bean.StoryBannerBean;
import com.example.firstweekexercise.interfaces.CallBack;
import com.example.firstweekexercise.model.StoryModel;
import com.example.firstweekexercise.view.StoryView;


public class StoryPresenterImp implements StoryPresenter, CallBack {
    private StoryModel storyModel;
    private StoryView storyView;

    public StoryPresenterImp(StoryModel storyModel, StoryView storyView) {
        this.storyModel = storyModel;
        this.storyView = storyView;
    }

    @Override
    public void getStoryData() {
        if (storyModel != null){
            storyModel.getStoryData(this);
        }
    }

    @Override
    public void onSuccess(StoryBannerBean data) {
        if (storyView != null && data != null){
            storyView.onSuccess(data);
        }
    }

    @Override
    public void onFail(String error) {
        if (storyView != null){
            storyView.onFail(error);
        }
    }
}
