package com.kaishengit.entity;

import java.sql.Timestamp;

public class Customer {

    private int id;
    private String custName;
    private String mobile;
    private String custText;
    private Timestamp createTime;
    private Timestamp updateTime;

    public String getCustText() {
        return custText;
    }

    public void setCustText(String custText) {
        this.custText = custText;
    }

    public Customer() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
