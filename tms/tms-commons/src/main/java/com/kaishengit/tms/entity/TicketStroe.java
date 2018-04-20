package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ticket_stroe
 * @author 
 */
public class TicketStroe implements Serializable {
    /**
     * 销售点id
     */
    private Integer id;

    /**
     * 销售点名称
     */
    private String stroeName;

    private String stroeManager;

    /**
     * 销售点手机号
     */
    private String stroeMobile;

    /**
     * 销售点地址
     */
    private String stroeAddress;

    /**
     * 销售点经度
     */
    private String stroeGeoLongitude;

    /**
     * 销售点维度
     */
    private String stroeGeoLatitude;

    /**
     * 销售点营业执照
     */
    private String stroeAttachment;

    /**
     * 销售点证件
     */
    private String stroeManagerAttachment;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStroeName() {
        return stroeName;
    }

    public void setStroeName(String stroeName) {
        this.stroeName = stroeName;
    }

    public String getStroeManager() {
        return stroeManager;
    }

    public void setStroeManager(String stroeManager) {
        this.stroeManager = stroeManager;
    }

    public String getStroeMobile() {
        return stroeMobile;
    }

    public void setStroeMobile(String stroeMobile) {
        this.stroeMobile = stroeMobile;
    }

    public String getStroeAddress() {
        return stroeAddress;
    }

    public void setStroeAddress(String stroeAddress) {
        this.stroeAddress = stroeAddress;
    }

    public String getStroeGeoLongitude() {
        return stroeGeoLongitude;
    }

    public void setStroeGeoLongitude(String stroeGeoLongitude) {
        this.stroeGeoLongitude = stroeGeoLongitude;
    }

    public String getStroeGeoLatitude() {
        return stroeGeoLatitude;
    }

    public void setStroeGeoLatitude(String stroeGeoLatitude) {
        this.stroeGeoLatitude = stroeGeoLatitude;
    }

    public String getStroeAttachment() {
        return stroeAttachment;
    }

    public void setStroeAttachment(String stroeAttachment) {
        this.stroeAttachment = stroeAttachment;
    }

    public String getStroeManagerAttachment() {
        return stroeManagerAttachment;
    }

    public void setStroeManagerAttachment(String stroeManagerAttachment) {
        this.stroeManagerAttachment = stroeManagerAttachment;
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
        TicketStroe other = (TicketStroe) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStroeName() == null ? other.getStroeName() == null : this.getStroeName().equals(other.getStroeName()))
            && (this.getStroeManager() == null ? other.getStroeManager() == null : this.getStroeManager().equals(other.getStroeManager()))
            && (this.getStroeMobile() == null ? other.getStroeMobile() == null : this.getStroeMobile().equals(other.getStroeMobile()))
            && (this.getStroeAddress() == null ? other.getStroeAddress() == null : this.getStroeAddress().equals(other.getStroeAddress()))
            && (this.getStroeGeoLongitude() == null ? other.getStroeGeoLongitude() == null : this.getStroeGeoLongitude().equals(other.getStroeGeoLongitude()))
            && (this.getStroeGeoLatitude() == null ? other.getStroeGeoLatitude() == null : this.getStroeGeoLatitude().equals(other.getStroeGeoLatitude()))
            && (this.getStroeAttachment() == null ? other.getStroeAttachment() == null : this.getStroeAttachment().equals(other.getStroeAttachment()))
            && (this.getStroeManagerAttachment() == null ? other.getStroeManagerAttachment() == null : this.getStroeManagerAttachment().equals(other.getStroeManagerAttachment()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStroeName() == null) ? 0 : getStroeName().hashCode());
        result = prime * result + ((getStroeManager() == null) ? 0 : getStroeManager().hashCode());
        result = prime * result + ((getStroeMobile() == null) ? 0 : getStroeMobile().hashCode());
        result = prime * result + ((getStroeAddress() == null) ? 0 : getStroeAddress().hashCode());
        result = prime * result + ((getStroeGeoLongitude() == null) ? 0 : getStroeGeoLongitude().hashCode());
        result = prime * result + ((getStroeGeoLatitude() == null) ? 0 : getStroeGeoLatitude().hashCode());
        result = prime * result + ((getStroeAttachment() == null) ? 0 : getStroeAttachment().hashCode());
        result = prime * result + ((getStroeManagerAttachment() == null) ? 0 : getStroeManagerAttachment().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stroeName=").append(stroeName);
        sb.append(", stroeManager=").append(stroeManager);
        sb.append(", stroeMobile=").append(stroeMobile);
        sb.append(", stroeAddress=").append(stroeAddress);
        sb.append(", stroeGeoLongitude=").append(stroeGeoLongitude);
        sb.append(", stroeGeoLatitude=").append(stroeGeoLatitude);
        sb.append(", stroeAttachment=").append(stroeAttachment);
        sb.append(", stroeManagerAttachment=").append(stroeManagerAttachment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}