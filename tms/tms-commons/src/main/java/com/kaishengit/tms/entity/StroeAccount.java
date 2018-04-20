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
        StroeAccount other = (StroeAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStroeAccount() == null ? other.getStroeAccount() == null : this.getStroeAccount().equals(other.getStroeAccount()))
            && (this.getStroePassword() == null ? other.getStroePassword() == null : this.getStroePassword().equals(other.getStroePassword()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStroeState() == null ? other.getStroeState() == null : this.getStroeState().equals(other.getStroeState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStroeAccount() == null) ? 0 : getStroeAccount().hashCode());
        result = prime * result + ((getStroePassword() == null) ? 0 : getStroePassword().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStroeState() == null) ? 0 : getStroeState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stroeAccount=").append(stroeAccount);
        sb.append(", stroePassword=").append(stroePassword);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", stroeState=").append(stroeState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}