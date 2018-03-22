package com.kaishengit.entity;

public class User {

   private int id;
   private String userName;
   private int age;
   private String phoneNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNume() {
        return phoneNum;
    }

    public void setPhoneNume(String phoneNume) {
        this.phoneNum = phoneNume;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", phoneNume='" + phoneNum + '\'' +
                '}';
    }
}
