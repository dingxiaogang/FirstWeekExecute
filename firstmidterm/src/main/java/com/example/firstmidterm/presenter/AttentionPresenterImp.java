package com.example.firstmidterm.presenter;

import com.example.firstmidterm.bean.AttentionBean;
import com.example.firstmidterm.interfaces.CallBack;
import com.example.firstmidterm.model.AttentionModel;
import com.example.firstmidterm.view.AttentionView;

public class AttentionPresenterImp implements AttentionPresenter, CallBack<AttentionBean> {
    private AttentionModel attentionModel;
    private AttentionView attentionView;

    public AttentionPresenterImp(AttentionModel attentionModel, AttentionView attentionView) {
        this.attentionModel = attentionModel;
        this.attentionView = attentionView;
    }

    @Override
    public void getData() {
        if (attentionModel != null){
            attentionModel.getData(this);
        }
    }

    @Override
    public void onSuccess(AttentionBean data) {
        if (attentionView != null){
            attentionView.onSuccess(data);
        }
    }

    @Override
    public void onFail(String error) {
        if (attentionView != null){
            attentionView.onFail(error);
        }
    }
}
