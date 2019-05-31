package com.example.fouredtest.view;

import com.example.fouredtest.bean.CreationChildBean;

public interface CreationChildView {
    void onSuccess(CreationChildBean data);
    void onFail(String error);
}
