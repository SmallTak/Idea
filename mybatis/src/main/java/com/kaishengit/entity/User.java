package com.kaishengit.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -5211389707739541364L;

    //   因为int的默认值为0，在某些请我们使用integer
   private Integer id;
   private String userName;
   private int age;
   private String phoneNum;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
