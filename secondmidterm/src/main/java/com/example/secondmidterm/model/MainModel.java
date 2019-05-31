package com.example.secondmidterm.model;

import com.example.secondmidterm.bean.MainBean;
import com.example.secondmidterm.interfaces.CallBack;

public interface MainModel {
    void getData(CallBack<MainBean> callBack);
}
