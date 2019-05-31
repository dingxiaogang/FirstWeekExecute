package com.example.secondmidterm.presenter;

import com.example.secondmidterm.bean.MainBean;
import com.example.secondmidterm.interfaces.CallBack;
import com.example.secondmidterm.model.MainModel;
import com.example.secondmidterm.view.MainView;

public class MainPresenterImp implements MainPresenter, CallBack<MainBean> {
    private MainModel mainModel;
    private MainView mainView;

    public MainPresenterImp(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void getData() {
        if (mainModel != null){
            mainModel.getData(this);
        }
    }

    @Override
    public void onSuccess(MainBean data) {
        if (mainView != null){
            mainView.onSuccess(data);
        }
    }

    @Override
    public void onFail(String error) {
        if (mainView != null){
            mainView.onFail(error);
        }
    }
}
