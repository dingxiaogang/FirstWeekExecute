package com.example.secondtest.model;

import com.example.secondtest.bean.ThemeBean;
import com.example.secondtest.interfaces.CallBack;

public interface ThemeModel {
    void getData(CallBack<ThemeBean> callBack);
}
