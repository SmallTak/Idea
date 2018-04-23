package com.kaishengit.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketOutRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TicketOutRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameIsNull() {
            addCriterion("ticket_out_account_name is null");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameIsNotNull() {
            addCriterion("ticket_out_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameEqualTo(String value) {
            addCriterion("ticket_out_account_name =", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameNotEqualTo(String value) {
            addCriterion("ticket_out_account_name <>", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameGreaterThan(String value) {
            addCriterion("ticket_out_account_name >", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_out_account_name >=", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameLessThan(String value) {
            addCriterion("ticket_out_account_name <", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameLessThanOrEqualTo(String value) {
            addCriterion("ticket_out_account_name <=", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameLike(String value) {
            addCriterion("ticket_out_account_name like", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameNotLike(String value) {
            addCriterion("ticket_out_account_name not like", value, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameIn(List<String> values) {
            addCriterion("ticket_out_account_name in", values, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameNotIn(List<String> values) {
            addCriterion("ticket_out_account_name not in", values, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameBetween(String value1, String value2) {
            addCriterion("ticket_out_account_name between", value1, value2, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketOutAccountNameNotBetween(String value1, String value2) {
            addCriterion("ticket_out_account_name not between", value1, value2, "ticketOutAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameIsNull() {
            addCriterion("finance_account_name is null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameIsNotNull() {
            addCriterion("finance_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameEqualTo(String value) {
            addCriterion("finance_account_name =", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotEqualTo(String value) {
            addCriterion("finance_account_name <>", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameGreaterThan(String value) {
            addCriterion("finance_account_name >", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("finance_account_name >=", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameLessThan(String value) {
            addCriterion("finance_account_name <", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameLessThanOrEqualTo(String value) {
            addCriterion("finance_account_name <=", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameLike(String value) {
            addCriterion("finance_account_name like", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotLike(String value) {
            addCriterion("finance_account_name not like", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameIn(List<String> values) {
            addCriterion("finance_account_name in", values, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotIn(List<String> values) {
            addCriterion("finance_account_name not in", values, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameBetween(String value1, String value2) {
            addCriterion("finance_account_name between", value1, value2, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotBetween(String value1, String value2) {
            addCriterion("finance_account_name not between", value1, value2, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andTicketStateIsNull() {
            addCriterion("ticket_state is null");
            return (Criteria) this;
        }

        public Criteria andTicketStateIsNotNull() {
            addCriterion("ticket_state is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStateEqualTo(String value) {
            addCriterion("ticket_state =", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotEqualTo(String value) {
            addCriterion("ticket_state <>", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateGreaterThan(String value) {
            addCriterion("ticket_state >", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_state >=", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateLessThan(String value) {
            addCriterion("ticket_state <", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateLessThanOrEqualTo(String value) {
            addCriterion("ticket_state <=", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateLike(String value) {
            addCriterion("ticket_state like", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotLike(String value) {
            addCriterion("ticket_state not like", value, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateIn(List<String> values) {
            addCriterion("ticket_state in", values, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotIn(List<String> values) {
            addCriterion("ticket_state not in", values, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateBetween(String value1, String value2) {
            addCriterion("ticket_state between", value1, value2, "ticketState");
            return (Criteria) this;
        }

        public Criteria andTicketStateNotBetween(String value1, String value2) {
            addCriterion("ticket_state not between", value1, value2, "ticketState");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumIsNull() {
            addCriterion("begin_ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumIsNotNull() {
            addCriterion("begin_ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumEqualTo(String value) {
            addCriterion("begin_ticket_num =", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotEqualTo(String value) {
            addCriterion("begin_ticket_num <>", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumGreaterThan(String value) {
            addCriterion("begin_ticket_num >", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumGreaterThanOrEqualTo(String value) {
            addCriterion("begin_ticket_num >=", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumLessThan(String value) {
            addCriterion("begin_ticket_num <", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumLessThanOrEqualTo(String value) {
            addCriterion("begin_ticket_num <=", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumLike(String value) {
            addCriterion("begin_ticket_num like", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotLike(String value) {
            addCriterion("begin_ticket_num not like", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumIn(List<String> values) {
            addCriterion("begin_ticket_num in", values, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotIn(List<String> values) {
            addCriterion("begin_ticket_num not in", values, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumBetween(String value1, String value2) {
            addCriterion("begin_ticket_num between", value1, value2, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotBetween(String value1, String value2) {
            addCriterion("begin_ticket_num not between", value1, value2, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumIsNull() {
            addCriterion("end_ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumIsNotNull() {
            addCriterion("end_ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumEqualTo(String value) {
            addCriterion("end_ticket_num =", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotEqualTo(String value) {
            addCriterion("end_ticket_num <>", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumGreaterThan(String value) {
            addCriterion("end_ticket_num >", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumGreaterThanOrEqualTo(String value) {
            addCriterion("end_ticket_num >=", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumLessThan(String value) {
            addCriterion("end_ticket_num <", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumLessThanOrEqualTo(String value) {
            addCriterion("end_ticket_num <=", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumLike(String value) {
            addCriterion("end_ticket_num like", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotLike(String value) {
            addCriterion("end_ticket_num not like", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumIn(List<String> values) {
            addCriterion("end_ticket_num in", values, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotIn(List<String> values) {
            addCriterion("end_ticket_num not in", values, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumBetween(String value1, String value2) {
            addCriterion("end_ticket_num between", value1, value2, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotBetween(String value1, String value2) {
            addCriterion("end_ticket_num not between", value1, value2, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNull() {
            addCriterion("ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNotNull() {
            addCriterion("ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNumEqualTo(Integer value) {
            addCriterion("ticket_num =", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotEqualTo(Integer value) {
            addCriterion("ticket_num <>", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThan(Integer value) {
            addCriterion("ticket_num >", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_num >=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThan(Integer value) {
            addCriterion("ticket_num <", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_num <=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumIn(List<Integer> values) {
            addCriterion("ticket_num in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotIn(List<Integer> values) {
            addCriterion("ticket_num not in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumBetween(Integer value1, Integer value2) {
            addCriterion("ticket_num between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_num not between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketPriceIsNull() {
            addCriterion("ticket_price is null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceIsNotNull() {
            addCriterion("ticket_price is not null");
            return (Criteria) this;
        }

        public Criteria andTicketPriceEqualTo(Long value) {
            addCriterion("ticket_price =", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceNotEqualTo(Long value) {
            addCriterion("ticket_price <>", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceGreaterThan(Long value) {
            addCriterion("ticket_price >", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("ticket_price >=", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceLessThan(Long value) {
            addCriterion("ticket_price <", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceLessThanOrEqualTo(Long value) {
            addCriterion("ticket_price <=", value, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceIn(List<Long> values) {
            addCriterion("ticket_price in", values, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceNotIn(List<Long> values) {
            addCriterion("ticket_price not in", values, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceBetween(Long value1, Long value2) {
            addCriterion("ticket_price between", value1, value2, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketPriceNotBetween(Long value1, Long value2) {
            addCriterion("ticket_price not between", value1, value2, "ticketPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceIsNull() {
            addCriterion("ticket_total_price is null");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceIsNotNull() {
            addCriterion("ticket_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceEqualTo(Long value) {
            addCriterion("ticket_total_price =", value, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceNotEqualTo(Long value) {
            addCriterion("ticket_total_price <>", value, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceGreaterThan(Long value) {
            addCriterion("ticket_total_price >", value, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("ticket_total_price >=", value, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceLessThan(Long value) {
            addCriterion("ticket_total_price <", value, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("ticket_total_price <=", value, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceIn(List<Long> values) {
            addCriterion("ticket_total_price in", values, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceNotIn(List<Long> values) {
            addCriterion("ticket_total_price not in", values, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceBetween(Long value1, Long value2) {
            addCriterion("ticket_total_price between", value1, value2, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("ticket_total_price not between", value1, value2, "ticketTotalPrice");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameIsNull() {
            addCriterion("ticket_store_accountName is null");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameIsNotNull() {
            addCriterion("ticket_store_accountName is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameEqualTo(String value) {
            addCriterion("ticket_store_accountName =", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameNotEqualTo(String value) {
            addCriterion("ticket_store_accountName <>", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameGreaterThan(String value) {
            addCriterion("ticket_store_accountName >", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_store_accountName >=", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameLessThan(String value) {
            addCriterion("ticket_store_accountName <", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameLessThanOrEqualTo(String value) {
            addCriterion("ticket_store_accountName <=", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameLike(String value) {
            addCriterion("ticket_store_accountName like", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameNotLike(String value) {
            addCriterion("ticket_store_accountName not like", value, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameIn(List<String> values) {
            addCriterion("ticket_store_accountName in", values, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameNotIn(List<String> values) {
            addCriterion("ticket_store_accountName not in", values, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameBetween(String value1, String value2) {
            addCriterion("ticket_store_accountName between", value1, value2, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountnameNotBetween(String value1, String value2) {
            addCriterion("ticket_store_accountName not between", value1, value2, "ticketStoreAccountname");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidIsNull() {
            addCriterion("ticket_store_accountId is null");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidIsNotNull() {
            addCriterion("ticket_store_accountId is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidEqualTo(Integer value) {
            addCriterion("ticket_store_accountId =", value, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidNotEqualTo(Integer value) {
            addCriterion("ticket_store_accountId <>", value, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidGreaterThan(Integer value) {
            addCriterion("ticket_store_accountId >", value, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_store_accountId >=", value, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidLessThan(Integer value) {
            addCriterion("ticket_store_accountId <", value, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_store_accountId <=", value, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidIn(List<Integer> values) {
            addCriterion("ticket_store_accountId in", values, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidNotIn(List<Integer> values) {
            addCriterion("ticket_store_accountId not in", values, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidBetween(Integer value1, Integer value2) {
            addCriterion("ticket_store_accountId between", value1, value2, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andTicketStoreAccountidNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_store_accountId not between", value1, value2, "ticketStoreAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidIsNull() {
            addCriterion("out_accountid is null");
            return (Criteria) this;
        }

        public Criteria andOutAccountidIsNotNull() {
            addCriterion("out_accountid is not null");
            return (Criteria) this;
        }

        public Criteria andOutAccountidEqualTo(Integer value) {
            addCriterion("out_accountid =", value, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidNotEqualTo(Integer value) {
            addCriterion("out_accountid <>", value, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidGreaterThan(Integer value) {
            addCriterion("out_accountid >", value, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_accountid >=", value, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidLessThan(Integer value) {
            addCriterion("out_accountid <", value, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidLessThanOrEqualTo(Integer value) {
            addCriterion("out_accountid <=", value, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidIn(List<Integer> values) {
            addCriterion("out_accountid in", values, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidNotIn(List<Integer> values) {
            addCriterion("out_accountid not in", values, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidBetween(Integer value1, Integer value2) {
            addCriterion("out_accountid between", value1, value2, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andOutAccountidNotBetween(Integer value1, Integer value2) {
            addCriterion("out_accountid not between", value1, value2, "outAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidIsNull() {
            addCriterion("finance_accountId is null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidIsNotNull() {
            addCriterion("finance_accountId is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidEqualTo(Integer value) {
            addCriterion("finance_accountId =", value, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidNotEqualTo(Integer value) {
            addCriterion("finance_accountId <>", value, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidGreaterThan(Integer value) {
            addCriterion("finance_accountId >", value, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("finance_accountId >=", value, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidLessThan(Integer value) {
            addCriterion("finance_accountId <", value, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidLessThanOrEqualTo(Integer value) {
            addCriterion("finance_accountId <=", value, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidIn(List<Integer> values) {
            addCriterion("finance_accountId in", values, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidNotIn(List<Integer> values) {
            addCriterion("finance_accountId not in", values, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidBetween(Integer value1, Integer value2) {
            addCriterion("finance_accountId between", value1, value2, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountidNotBetween(Integer value1, Integer value2) {
            addCriterion("finance_accountId not between", value1, value2, "financeAccountid");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("payment_method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("payment_method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}