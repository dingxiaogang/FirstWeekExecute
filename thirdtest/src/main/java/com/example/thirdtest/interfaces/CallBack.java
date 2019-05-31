package com.example.thirdtest.interfaces;

public interface CallBack<T> {
    void onSuccess(T data);
    void onFail(String error);
}
