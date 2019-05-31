package com.example.secondmidterm.interfaces;

public interface CallBack<T> {
    void onSuccess(T data);
    void onFail(String error);
}
