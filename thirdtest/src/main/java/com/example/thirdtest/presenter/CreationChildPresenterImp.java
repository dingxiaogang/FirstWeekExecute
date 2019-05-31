package com.example.thirdtest.presenter;

import com.example.thirdtest.bean.CreationChildBean;
import com.example.thirdtest.interfaces.CallBack;
import com.example.thirdtest.model.CreationChildModel;
import com.example.thirdtest.view.CreationChildView;

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
