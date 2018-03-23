package com.kaishengit.entity;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {

    private static final long serialVersionUID = -5211389707739541364L;

    private Integer id;
    private String studentName;
    private int age;
    private String address;
    private Integer schoolId;
    private School school;
    private List<Tag> tagList;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", schoolId=" + schoolId +
                ", school=" + school +
                ", tagList=" + tagList +
                '}';
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
