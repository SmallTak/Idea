package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统登录账号实体类
 * @Author Reich
 * @Date: 2018/4/12 19:11  
 */
public class Account implements Serializable {

    public static final String STATE_NORMAL = "正常";
    public static final String STATE_DISABLE = "禁用";
    public static final String STATE_LOCKED = "锁定";

    /**
     * 主键，un表示无符号，没有负数

     */
    private Integer id;

    /**
     * 账号名称
     */
    private String accountName;

    /**
     * 用户手机号
     */
    private String accountMobile;

    /**
     * 密码使用md5加密
     */
    private String accountPassword;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 账户更新时间
     */
    private Date updateTime;

    /**
     * 账号状态
     */
    private String accountState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountMobile() {
        return accountMobile;
    }

    public void setAccountMobile(String accountMobile) {
        this.accountMobile = accountMobile;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
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

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", accountMobile='" + accountMobile + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", accountState='" + accountState + '\'' +
                '}';
    }
}