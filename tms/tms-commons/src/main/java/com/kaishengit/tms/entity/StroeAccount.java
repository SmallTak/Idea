package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * stroe_account
 * @author 
 */
public class StroeAccount implements Serializable {

    public static final String ACCOUNT_STATE_NORMAL = "正常";
    public static final String ACCOUNT_STATE_DISABLE = "禁用";

    private Integer id;

    /**
     * 销售点用户
     */
    private String stroeAccount;

    /**
     * 销售点用户密码
     */
    private String stroePassword;

    /**
     * 销售点用户创建时间
     */
    private Date createTime;

    /**
     * 销售点用户更新时间
     */
    private Date updateTime;

    /**
     * 销售点用户的状态
     */
    private String stroeState;

    private Integer ticketStroeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStroeAccount() {
        return stroeAccount;
    }

    public void setStroeAccount(String stroeAccount) {
        this.stroeAccount = stroeAccount;
    }

    public String getStroePassword() {
        return stroePassword;
    }

    public void setStroePassword(String stroePassword) {
        this.stroePassword = stroePassword;
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

    public String getStroeState() {
        return stroeState;
    }

    public void setStroeState(String stroeState) {
        this.stroeState = stroeState;
    }

    public Integer getTicketStroeId() {
        return ticketStroeId;
    }

    public void setTicketStroeId(Integer ticketStroeId) {
        this.ticketStroeId = ticketStroeId;
    }
}