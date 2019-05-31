package com.example.thirdtest.view;

import com.example.thirdtest.bean.CreationChildBean;

public interface CreationChildView {
    void onSuccess(CreationChildBean data);
    void onFail(String error);
}
