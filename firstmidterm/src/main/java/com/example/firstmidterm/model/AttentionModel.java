package com.example.firstmidterm.model;

import com.example.firstmidterm.bean.AttentionBean;
import com.example.firstmidterm.interfaces.CallBack;

public interface AttentionModel {
    void getData(CallBack<AttentionBean> callBack);
}
