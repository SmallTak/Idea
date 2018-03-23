package com.kaishengit.entity;

public class Student {

    private Integer id;
    private String userName;
    private int age;
    private String address;
    private Integer schoolId;
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + userName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", schoolId=" + schoolId +
                ", school=" + school +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return userName;
    }

    public void setStudentName(String studentName) {
        this.userName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
