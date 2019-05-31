package com.example.secondtest.presenter;

import com.example.secondtest.bean.ThemeBean;
import com.example.secondtest.interfaces.CallBack;
import com.example.secondtest.model.ThemeModel;
import com.example.secondtest.view.ThemeView;

public class ThemePresenterImp implements ThemePresenter, CallBack<ThemeBean> {
    private ThemeModel themeModel;
    private ThemeView themeView;

    public ThemePresenterImp(ThemeModel themeModel, ThemeView themeView) {
        this.themeModel = themeModel;
        this.themeView = themeView;
    }

    @Override
    public void getData() {
        if (themeModel != null){
            themeModel.getData(this);
        }
    }

    @Override
    public void onSuccess(ThemeBean data) {
        if (themeView != null){
            themeView.onSuccess(data);
        }
    }

    @Override
    public void onFail(String error) {
        if (themeView != null){
            themeView.onFail(error);
        }
    }
}
