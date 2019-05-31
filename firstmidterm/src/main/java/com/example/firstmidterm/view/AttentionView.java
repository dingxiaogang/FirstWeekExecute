package com.example.firstmidterm.view;

import com.example.firstmidterm.bean.AttentionBean;

public interface AttentionView {
    void onSuccess(AttentionBean attentionBean);
    void onFail(String error);
}
