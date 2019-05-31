package com.example.designmode.observer;

import java.util.Scanner;

public class ObserverTest {
    public static void main(String[] args){
        Person person = new Person();

        person.setOnAgeChangeListener(new Person.setAgeChange() {
            @Override
            public void onChange(int age) {
                System.out.println("age change ==> " + age);
            }
        });

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄:");
        int anInt = scanner.nextInt();
        person.setAge(anInt);
        scanner.close();
    }
}
