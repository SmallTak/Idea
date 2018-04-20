package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ticket
 * @author 
 */
public class Ticket implements Serializable {

    public static final String TICKET_STATE_IN_STORE = "已入库";
    public static final String TICKET_STATE_OUT_STORE = "已下发";
    public static final String TICKET_STATE_SALE = "已销售";
    public static final String TICKET_STATE_LOST = "已挂失";
    public static final String TICKET_STATE_OUT_DATE = "已过期";

    private Integer id;

    /**
     * 入库年票中数量
     */
    private String ticketNum;

    /**
     * 入库时间
     */
    private Date ticketInTime;

    /**
     * 年票状态
     */
    private String ticketState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 出库时间
     */
    private String ticketOutTime;

    /**
     * 代理人id
     */
    private Integer stroeAccountId;

    /**
     * 年票起始
     */
    private String ticketValidityStart;

    /**
     * 年票结束
     */
    private String ticketValidityEnd;

    private Integer customerId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Date getTicketInTime() {
        return ticketInTime;
    }

    public void setTicketInTime(Date ticketInTime) {
        this.ticketInTime = ticketInTime;
    }

    public String getTicketState() {
        return ticketState;
    }

    public void setTicketState(String ticketState) {
        this.ticketState = ticketState;
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

    public String getTicketOutTime() {
        return ticketOutTime;
    }

    public void setTicketOutTime(String ticketOutTime) {
        this.ticketOutTime = ticketOutTime;
    }

    public Integer getStroeAccountId() {
        return stroeAccountId;
    }

    public void setStroeAccountId(Integer stroeAccountId) {
        this.stroeAccountId = stroeAccountId;
    }

    public String getTicketValidityStart() {
        return ticketValidityStart;
    }

    public void setTicketValidityStart(String ticketValidityStart) {
        this.ticketValidityStart = ticketValidityStart;
    }

    public String getTicketValidityEnd() {
        return ticketValidityEnd;
    }

    public void setTicketValidityEnd(String ticketValidityEnd) {
        this.ticketValidityEnd = ticketValidityEnd;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}