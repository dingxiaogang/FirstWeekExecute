package com.example.secondtest.view;

import com.example.secondtest.bean.ThemeBean;

public interface ThemeView {
    void onSuccess(ThemeBean themeBean);
    void onFail(String error);
}
