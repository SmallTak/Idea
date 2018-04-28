package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ticket_order
 * @author 
 */
public class TicketOrder implements Serializable {

    public static final String ORDER_TYPE_NEW = "新办订单";
    public static final String ORDER_TYPE_RENEW = "续费订单";
    public static final String ORDER_TYPE_REPLACE = "补办订单";

    private Integer idticketOrder;

    /**
     * 年票号
     */
    private String ticketOrderNum;

    /**
     * 年票价格
     */
    private Long ticketOrdePrice;

    /**
     * 年票id
     */
    private Integer ticketId;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 代理人id

     */
    private Integer stroeAccountId;

    /**
     * 购买年票的类型
     */
    private String ticketOrderType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getIdticketOrder() {
        return idticketOrder;
    }

    public void setIdticketOrder(Integer idticketOrder) {
        this.idticketOrder = idticketOrder;
    }

    public String getTicketOrderNum() {
        return ticketOrderNum;
    }

    public void setTicketOrderNum(String ticketOrderNum) {
        this.ticketOrderNum = ticketOrderNum;
    }

    public Long getTicketOrdePrice() {
        return ticketOrdePrice;
    }

    public void setTicketOrdePrice(Long ticketOrdePrice) {
        this.ticketOrdePrice = ticketOrdePrice;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStroeAccountId() {
        return stroeAccountId;
    }

    public void setStroeAccountId(Integer stroeAccountId) {
        this.stroeAccountId = stroeAccountId;
    }

    public String getTicketOrderType() {
        return ticketOrderType;
    }

    public void setTicketOrderType(String ticketOrderType) {
        this.ticketOrderType = ticketOrderType;
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
        TicketOrder other = (TicketOrder) that;
        return (this.getIdticketOrder() == null ? other.getIdticketOrder() == null : this.getIdticketOrder().equals(other.getIdticketOrder()))
            && (this.getTicketOrderNum() == null ? other.getTicketOrderNum() == null : this.getTicketOrderNum().equals(other.getTicketOrderNum()))
            && (this.getTicketOrdePrice() == null ? other.getTicketOrdePrice() == null : this.getTicketOrdePrice().equals(other.getTicketOrdePrice()))
            && (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getStroeAccountId() == null ? other.getStroeAccountId() == null : this.getStroeAccountId().equals(other.getStroeAccountId()))
            && (this.getTicketOrderType() == null ? other.getTicketOrderType() == null : this.getTicketOrderType().equals(other.getTicketOrderType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdticketOrder() == null) ? 0 : getIdticketOrder().hashCode());
        result = prime * result + ((getTicketOrderNum() == null) ? 0 : getTicketOrderNum().hashCode());
        result = prime * result + ((getTicketOrdePrice() == null) ? 0 : getTicketOrdePrice().hashCode());
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getStroeAccountId() == null) ? 0 : getStroeAccountId().hashCode());
        result = prime * result + ((getTicketOrderType() == null) ? 0 : getTicketOrderType().hashCode());
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
        sb.append(", idticketOrder=").append(idticketOrder);
        sb.append(", ticketOrderNum=").append(ticketOrderNum);
        sb.append(", ticketOrdePrice=").append(ticketOrdePrice);
        sb.append(", ticketId=").append(ticketId);
        sb.append(", customerId=").append(customerId);
        sb.append(", stroeAccountId=").append(stroeAccountId);
        sb.append(", ticketOrderType=").append(ticketOrderType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}