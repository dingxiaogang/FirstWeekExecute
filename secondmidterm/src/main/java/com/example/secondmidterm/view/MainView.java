package com.example.secondmidterm.view;

import com.example.secondmidterm.bean.MainBean;

public interface MainView {
    void onSuccess(MainBean data);
    void onFail(String error);
}
