package com.example.secondtest.interfaces;

public interface CallBack<T> {
    void onSuccess(T data);
    void onFail(String error);
}
