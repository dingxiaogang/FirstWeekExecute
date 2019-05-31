package com.example.designmode.singleton;

public class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 singleton4 = new Singleton4();
    }

    private Singleton4(){}

    public static final Singleton4 getSingleton4(){
        return SingletonHolder.singleton4;
    }
}
