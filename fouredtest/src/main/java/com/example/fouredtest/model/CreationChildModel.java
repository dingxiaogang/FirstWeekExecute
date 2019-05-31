package com.example.fouredtest.model;

import com.example.fouredtest.bean.CreationChildBean;
import com.example.fouredtest.interfaces.CallBack;

public interface CreationChildModel {
    void getData(int cid, CallBack<CreationChildBean> callBack);
}
