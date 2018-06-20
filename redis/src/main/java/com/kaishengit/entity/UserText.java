package com.kaishengit.entity;

public class UserText {

    private String userName;
    private String phoneNum;
    private String Email;
    private String password;

    public UserText(String userName, String phoneNum, String email, String password) {
        this.userName = userName;
        this.phoneNum = phoneNum;
        Email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "UserText{" +
                "userName='" + userName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
