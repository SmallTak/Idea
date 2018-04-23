package com.kaishengit.tms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ticket_out_record
 * @author 
 */
public class TicketOutRecord implements Serializable {

    public static final String STATE_NO_PAY = "未支付";
    public static final String STATE_PAY = "已支付";

    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 下发人
     */
    private String ticketOutAccountName;

    /**
     * 财务收款人
     */
    private String financeAccountName;

    /**
     * 年票状态
     */
    private String ticketState;

    /**
     * 内容
     */
    private String content;

    /**
     * 起始票号
     */
    private String beginTicketNum;

    /**
     * 截至票号
     */
    private String endTicketNum;

    /**
     * 下发年票数量
     */
    private Integer ticketNum;

    /**
     * 年片单价
     */
    private BigDecimal ticketPrice;

    /**
     * 年票总价
     */
    private BigDecimal ticketTotalPrice;

    /**
     * 下发的售票点名称
     */
    private String ticketStoreAccountname;

    /**
     * 下发售票点ID
     */
    private Integer ticketStoreAccountid;

    /**
     * 年票下发人id
     */
    private Integer outAccountid;

    /**
     * 收款人id
     */
    private Integer financeAccountid;

    /**
     * 支付方式
     */
    private String paymentMethod;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTicketOutAccountName() {
        return ticketOutAccountName;
    }

    public void setTicketOutAccountName(String ticketOutAccountName) {
        this.ticketOutAccountName = ticketOutAccountName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public BigDecimal getTicketTotalPrice() {
        return ticketTotalPrice;
    }

    public void setTicketTotalPrice(BigDecimal ticketTotalPrice) {
        this.ticketTotalPrice = ticketTotalPrice;
    }

    public String getFinanceAccountName() {
        return financeAccountName;
    }

    public void setFinanceAccountName(String financeAccountName) {
        this.financeAccountName = financeAccountName;
    }

    public String getTicketState() {
        return ticketState;
    }

    public void setTicketState(String ticketState) {
        this.ticketState = ticketState;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBeginTicketNum() {
        return beginTicketNum;
    }

    public void setBeginTicketNum(String beginTicketNum) {
        this.beginTicketNum = beginTicketNum;
    }

    public String getEndTicketNum() {
        return endTicketNum;
    }

    public void setEndTicketNum(String endTicketNum) {
        this.endTicketNum = endTicketNum;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }


    public String getTicketStoreAccountname() {
        return ticketStoreAccountname;
    }

    public void setTicketStoreAccountname(String ticketStoreAccountname) {
        this.ticketStoreAccountname = ticketStoreAccountname;
    }

    public Integer getTicketStoreAccountid() {
        return ticketStoreAccountid;
    }

    public void setTicketStoreAccountid(Integer ticketStoreAccountid) {
        this.ticketStoreAccountid = ticketStoreAccountid;
    }

    public Integer getOutAccountid() {
        return outAccountid;
    }

    public void setOutAccountid(Integer outAccountid) {
        this.outAccountid = outAccountid;
    }

    public Integer getFinanceAccountid() {
        return financeAccountid;
    }

    public void setFinanceAccountid(Integer financeAccountid) {
        this.financeAccountid = financeAccountid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


}