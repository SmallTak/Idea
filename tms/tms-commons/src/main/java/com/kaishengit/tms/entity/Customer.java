package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * customer
 * @author 
 */
public class Customer implements Serializable {
    private Integer id;

    /**
     * 客户名
     */
    private String customerName;

    /**
     * 客户年龄
     */
    private Integer customerAge;

    /**
     * 客户住址
     */
    private String customerAddress;

    /**
     * 客户性别
     */
    private String customerSex;

    /**
     * 客户身份证
     */
    private String customerIdCard;

    /**
     * 客户手机号
     */
    private String customerMobile;

    /**
     * 身份证正面
     */
    private String customerCardPositive;

    /**
     * 身份证反面照
     */
    private String customerCardCounter;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 客户一寸照片
     */
    private String customerPhoto;

    /**
     * 客户持有年票id
     */
    private String customerTicketId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerCardPositive() {
        return customerCardPositive;
    }

    public void setCustomerCardPositive(String customerCardPositive) {
        this.customerCardPositive = customerCardPositive;
    }

    public String getCustomerCardCounter() {
        return customerCardCounter;
    }

    public void setCustomerCardCounter(String customerCardCounter) {
        this.customerCardCounter = customerCardCounter;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCustomerPhoto() {
        return customerPhoto;
    }

    public void setCustomerPhoto(String customerPhoto) {
        this.customerPhoto = customerPhoto;
    }

    public String getCustomerTicketId() {
        return customerTicketId;
    }

    public void setCustomerTicketId(String customerTicketId) {
        this.customerTicketId = customerTicketId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Customer other = (Customer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getCustomerAge() == null ? other.getCustomerAge() == null : this.getCustomerAge().equals(other.getCustomerAge()))
            && (this.getCustomerAddress() == null ? other.getCustomerAddress() == null : this.getCustomerAddress().equals(other.getCustomerAddress()))
            && (this.getCustomerSex() == null ? other.getCustomerSex() == null : this.getCustomerSex().equals(other.getCustomerSex()))
            && (this.getCustomerIdCard() == null ? other.getCustomerIdCard() == null : this.getCustomerIdCard().equals(other.getCustomerIdCard()))
            && (this.getCustomerMobile() == null ? other.getCustomerMobile() == null : this.getCustomerMobile().equals(other.getCustomerMobile()))
            && (this.getCustomerCardPositive() == null ? other.getCustomerCardPositive() == null : this.getCustomerCardPositive().equals(other.getCustomerCardPositive()))
            && (this.getCustomerCardCounter() == null ? other.getCustomerCardCounter() == null : this.getCustomerCardCounter().equals(other.getCustomerCardCounter()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCustomerPhoto() == null ? other.getCustomerPhoto() == null : this.getCustomerPhoto().equals(other.getCustomerPhoto()))
            && (this.getCustomerTicketId() == null ? other.getCustomerTicketId() == null : this.getCustomerTicketId().equals(other.getCustomerTicketId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getCustomerAge() == null) ? 0 : getCustomerAge().hashCode());
        result = prime * result + ((getCustomerAddress() == null) ? 0 : getCustomerAddress().hashCode());
        result = prime * result + ((getCustomerSex() == null) ? 0 : getCustomerSex().hashCode());
        result = prime * result + ((getCustomerIdCard() == null) ? 0 : getCustomerIdCard().hashCode());
        result = prime * result + ((getCustomerMobile() == null) ? 0 : getCustomerMobile().hashCode());
        result = prime * result + ((getCustomerCardPositive() == null) ? 0 : getCustomerCardPositive().hashCode());
        result = prime * result + ((getCustomerCardCounter() == null) ? 0 : getCustomerCardCounter().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCustomerPhoto() == null) ? 0 : getCustomerPhoto().hashCode());
        result = prime * result + ((getCustomerTicketId() == null) ? 0 : getCustomerTicketId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerName=").append(customerName);
        sb.append(", customerAge=").append(customerAge);
        sb.append(", customerAddress=").append(customerAddress);
        sb.append(", customerSex=").append(customerSex);
        sb.append(", customerIdCard=").append(customerIdCard);
        sb.append(", customerMobile=").append(customerMobile);
        sb.append(", customerCardPositive=").append(customerCardPositive);
        sb.append(", customerCardCounter=").append(customerCardCounter);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", customerPhoto=").append(customerPhoto);
        sb.append(", customerTicketId=").append(customerTicketId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}