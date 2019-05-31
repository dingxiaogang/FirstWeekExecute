package com.example.designmode.builder;

public class BuilderBean {
    private int id;
    private int age;
    private int code;
    private String name;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "BuilderBean{" +
                "id=" + id +
                ", age=" + age +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public static class Builder{
        BuilderBean builderBean;

        public Builder(){
            builderBean = new BuilderBean();
        }

        public Builder setId(int id){
            builderBean.setId(id);
            return this;
        }

        public Builder setAge(int age){
            builderBean.setAge(age);
            return this;
        }

        public Builder setCode(int code){
            builderBean.setCode(code);
            return this;
        }

        public Builder setName(String name){
            builderBean.setName(name);
            return this;
        }

        public Builder setSex(String sex){
            builderBean.setSex(sex);
            return this;
        }

        public BuilderBean build(){
            return builderBean;
        }
    }
}
