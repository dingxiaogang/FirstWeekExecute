package com.example.thirdtest.model;

import com.example.thirdtest.bean.CreationChildBean;
import com.example.thirdtest.interfaces.CallBack;

public interface CreationChildModel {
    void getData(int cid, CallBack<CreationChildBean> callBack);
}
