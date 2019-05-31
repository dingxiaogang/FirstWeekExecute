package com.example.designmode.singleton;

public class SingletonTest {
    public static void main(String[] args){
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton11 = Singleton.getSingleton();

        System.out.println("饿汉式:");
        System.out.println(singleton1);
        System.out.println(singleton11);

        Singleton2 singleton2 = Singleton2.getSingleton2();
        Singleton2 singleton22 = Singleton2.getSingleton2();

        System.out.println("懒汉式:");
        System.out.println(singleton2);
        System.out.println(singleton22);

        Singleton3 singleton3 = Singleton3.getSingleton3();
        Singleton3 singleton33 = Singleton3.getSingleton3();

        System.out.println("双重锁汉式:");
        System.out.println(singleton3);
        System.out.println(singleton33);

        Singleton4 singleton4 = Singleton4.getSingleton4();
        Singleton4 singleton44 = Singleton4.getSingleton4();

        System.out.println("内部类:");
        System.out.println(singleton4);
        System.out.println(singleton44);
    }
}
