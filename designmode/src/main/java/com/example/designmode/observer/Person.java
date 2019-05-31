package com.example.designmode.observer;

public class Person {
    private int age = 20;
    private setAgeChange ageChange;

    public void setAge(int age) {
        if (age != this.age){
            if (ageChange == null){
                ageChange.onChange(21);
            }
        }
        this.age = age;
    }

    public interface setAgeChange {
        void onChange(int age);
    }
    public void setOnAgeChangeListener(setAgeChange ageChange){
        this.ageChange = ageChange;
    }
}
