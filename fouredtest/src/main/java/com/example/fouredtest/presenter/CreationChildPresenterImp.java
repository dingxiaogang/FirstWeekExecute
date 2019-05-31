package com.example.fouredtest.presenter;

import com.example.fouredtest.bean.CreationChildBean;
import com.example.fouredtest.interfaces.CallBack;
import com.example.fouredtest.model.CreationChildModel;
import com.example.fouredtest.view.CreationChildView;

public class CreationChildPresenterImp implements CreationChildPresenter, CallBack<CreationChildBean> {
    private CreationChildModel childModel;
    private CreationChildView childView;

    public CreationChildPresenterImp(CreationChildModel childModel, CreationChildView childView) {
        this.childModel = childModel;
        this.childView = childView;
    }

    @Override
    public void getData(int cid) {
        if (childModel != null){
            childModel.getData(cid,this);
        }
    }

    @Override
    public void onSuccess(CreationChildBean data) {
        if (childView != null){
            childView.onSuccess(data);
        }
    }

    @Override
    public void onFail(String error) {
        if (childView != null){
            childView.onFail(error);
        }
    }
}
