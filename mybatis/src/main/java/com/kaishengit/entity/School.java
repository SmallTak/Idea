package com.kaishengit.entity;

import java.io.Serializable;

public class School implements Serializable  {
    private Integer id;
    private String SchoolName;
    private String tel;

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", SchoolName='" + SchoolName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



}
