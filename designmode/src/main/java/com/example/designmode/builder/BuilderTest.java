package com.example.designmode.builder;

public class BuilderTest {
    public static void main(String[] args){
        BuilderBean builderBean = new BuilderBean.Builder().setId(0).setName("张三").setAge(15)
                .setSex("男").setCode(1).build();
        System.out.println(builderBean.toString());
    }
}
