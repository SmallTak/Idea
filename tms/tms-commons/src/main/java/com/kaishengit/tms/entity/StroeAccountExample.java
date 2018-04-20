package com.kaishengit.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StroeAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StroeAccountExample() {
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

        public Criteria andStroeAccountIsNull() {
            addCriterion("stroe_account is null");
            return (Criteria) this;
        }

        public Criteria andStroeAccountIsNotNull() {
            addCriterion("stroe_account is not null");
            return (Criteria) this;
        }

        public Criteria andStroeAccountEqualTo(String value) {
            addCriterion("stroe_account =", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountNotEqualTo(String value) {
            addCriterion("stroe_account <>", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountGreaterThan(String value) {
            addCriterion("stroe_account >", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_account >=", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountLessThan(String value) {
            addCriterion("stroe_account <", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountLessThanOrEqualTo(String value) {
            addCriterion("stroe_account <=", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountLike(String value) {
            addCriterion("stroe_account like", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountNotLike(String value) {
            addCriterion("stroe_account not like", value, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountIn(List<String> values) {
            addCriterion("stroe_account in", values, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountNotIn(List<String> values) {
            addCriterion("stroe_account not in", values, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountBetween(String value1, String value2) {
            addCriterion("stroe_account between", value1, value2, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroeAccountNotBetween(String value1, String value2) {
            addCriterion("stroe_account not between", value1, value2, "stroeAccount");
            return (Criteria) this;
        }

        public Criteria andStroePasswordIsNull() {
            addCriterion("stroe_password is null");
            return (Criteria) this;
        }

        public Criteria andStroePasswordIsNotNull() {
            addCriterion("stroe_password is not null");
            return (Criteria) this;
        }

        public Criteria andStroePasswordEqualTo(String value) {
            addCriterion("stroe_password =", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordNotEqualTo(String value) {
            addCriterion("stroe_password <>", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordGreaterThan(String value) {
            addCriterion("stroe_password >", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_password >=", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordLessThan(String value) {
            addCriterion("stroe_password <", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordLessThanOrEqualTo(String value) {
            addCriterion("stroe_password <=", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordLike(String value) {
            addCriterion("stroe_password like", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordNotLike(String value) {
            addCriterion("stroe_password not like", value, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordIn(List<String> values) {
            addCriterion("stroe_password in", values, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordNotIn(List<String> values) {
            addCriterion("stroe_password not in", values, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordBetween(String value1, String value2) {
            addCriterion("stroe_password between", value1, value2, "stroePassword");
            return (Criteria) this;
        }

        public Criteria andStroePasswordNotBetween(String value1, String value2) {
            addCriterion("stroe_password not between", value1, value2, "stroePassword");
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

        public Criteria andStroeStateIsNull() {
            addCriterion("stroe_state is null");
            return (Criteria) this;
        }

        public Criteria andStroeStateIsNotNull() {
            addCriterion("stroe_state is not null");
            return (Criteria) this;
        }

        public Criteria andStroeStateEqualTo(String value) {
            addCriterion("stroe_state =", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateNotEqualTo(String value) {
            addCriterion("stroe_state <>", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateGreaterThan(String value) {
            addCriterion("stroe_state >", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_state >=", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateLessThan(String value) {
            addCriterion("stroe_state <", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateLessThanOrEqualTo(String value) {
            addCriterion("stroe_state <=", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateLike(String value) {
            addCriterion("stroe_state like", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateNotLike(String value) {
            addCriterion("stroe_state not like", value, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateIn(List<String> values) {
            addCriterion("stroe_state in", values, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateNotIn(List<String> values) {
            addCriterion("stroe_state not in", values, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateBetween(String value1, String value2) {
            addCriterion("stroe_state between", value1, value2, "stroeState");
            return (Criteria) this;
        }

        public Criteria andStroeStateNotBetween(String value1, String value2) {
            addCriterion("stroe_state not between", value1, value2, "stroeState");
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