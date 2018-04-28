package com.kaishengit.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIsNull() {
            addCriterion("customer_age is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIsNotNull() {
            addCriterion("customer_age is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeEqualTo(Integer value) {
            addCriterion("customer_age =", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotEqualTo(Integer value) {
            addCriterion("customer_age <>", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThan(Integer value) {
            addCriterion("customer_age >", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_age >=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThan(Integer value) {
            addCriterion("customer_age <", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThanOrEqualTo(Integer value) {
            addCriterion("customer_age <=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIn(List<Integer> values) {
            addCriterion("customer_age in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotIn(List<Integer> values) {
            addCriterion("customer_age not in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeBetween(Integer value1, Integer value2) {
            addCriterion("customer_age between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_age not between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNull() {
            addCriterion("customer_address is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNotNull() {
            addCriterion("customer_address is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressEqualTo(String value) {
            addCriterion("customer_address =", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotEqualTo(String value) {
            addCriterion("customer_address <>", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThan(String value) {
            addCriterion("customer_address >", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("customer_address >=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThan(String value) {
            addCriterion("customer_address <", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThanOrEqualTo(String value) {
            addCriterion("customer_address <=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLike(String value) {
            addCriterion("customer_address like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotLike(String value) {
            addCriterion("customer_address not like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIn(List<String> values) {
            addCriterion("customer_address in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotIn(List<String> values) {
            addCriterion("customer_address not in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressBetween(String value1, String value2) {
            addCriterion("customer_address between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotBetween(String value1, String value2) {
            addCriterion("customer_address not between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNull() {
            addCriterion("customer_sex is null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNotNull() {
            addCriterion("customer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexEqualTo(String value) {
            addCriterion("customer_sex =", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotEqualTo(String value) {
            addCriterion("customer_sex <>", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThan(String value) {
            addCriterion("customer_sex >", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThanOrEqualTo(String value) {
            addCriterion("customer_sex >=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThan(String value) {
            addCriterion("customer_sex <", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThanOrEqualTo(String value) {
            addCriterion("customer_sex <=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLike(String value) {
            addCriterion("customer_sex like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotLike(String value) {
            addCriterion("customer_sex not like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIn(List<String> values) {
            addCriterion("customer_sex in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotIn(List<String> values) {
            addCriterion("customer_sex not in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexBetween(String value1, String value2) {
            addCriterion("customer_sex between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotBetween(String value1, String value2) {
            addCriterion("customer_sex not between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardIsNull() {
            addCriterion("customer_id_card is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardIsNotNull() {
            addCriterion("customer_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardEqualTo(String value) {
            addCriterion("customer_id_card =", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotEqualTo(String value) {
            addCriterion("customer_id_card <>", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardGreaterThan(String value) {
            addCriterion("customer_id_card >", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id_card >=", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardLessThan(String value) {
            addCriterion("customer_id_card <", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardLessThanOrEqualTo(String value) {
            addCriterion("customer_id_card <=", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardLike(String value) {
            addCriterion("customer_id_card like", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotLike(String value) {
            addCriterion("customer_id_card not like", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardIn(List<String> values) {
            addCriterion("customer_id_card in", values, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotIn(List<String> values) {
            addCriterion("customer_id_card not in", values, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardBetween(String value1, String value2) {
            addCriterion("customer_id_card between", value1, value2, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotBetween(String value1, String value2) {
            addCriterion("customer_id_card not between", value1, value2, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileIsNull() {
            addCriterion("customer_mobile is null");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileIsNotNull() {
            addCriterion("customer_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileEqualTo(String value) {
            addCriterion("customer_mobile =", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotEqualTo(String value) {
            addCriterion("customer_mobile <>", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileGreaterThan(String value) {
            addCriterion("customer_mobile >", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileGreaterThanOrEqualTo(String value) {
            addCriterion("customer_mobile >=", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileLessThan(String value) {
            addCriterion("customer_mobile <", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileLessThanOrEqualTo(String value) {
            addCriterion("customer_mobile <=", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileLike(String value) {
            addCriterion("customer_mobile like", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotLike(String value) {
            addCriterion("customer_mobile not like", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileIn(List<String> values) {
            addCriterion("customer_mobile in", values, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotIn(List<String> values) {
            addCriterion("customer_mobile not in", values, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileBetween(String value1, String value2) {
            addCriterion("customer_mobile between", value1, value2, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotBetween(String value1, String value2) {
            addCriterion("customer_mobile not between", value1, value2, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveIsNull() {
            addCriterion("customer_card_positive is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveIsNotNull() {
            addCriterion("customer_card_positive is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveEqualTo(String value) {
            addCriterion("customer_card_positive =", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveNotEqualTo(String value) {
            addCriterion("customer_card_positive <>", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveGreaterThan(String value) {
            addCriterion("customer_card_positive >", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveGreaterThanOrEqualTo(String value) {
            addCriterion("customer_card_positive >=", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveLessThan(String value) {
            addCriterion("customer_card_positive <", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveLessThanOrEqualTo(String value) {
            addCriterion("customer_card_positive <=", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveLike(String value) {
            addCriterion("customer_card_positive like", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveNotLike(String value) {
            addCriterion("customer_card_positive not like", value, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveIn(List<String> values) {
            addCriterion("customer_card_positive in", values, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveNotIn(List<String> values) {
            addCriterion("customer_card_positive not in", values, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveBetween(String value1, String value2) {
            addCriterion("customer_card_positive between", value1, value2, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardPositiveNotBetween(String value1, String value2) {
            addCriterion("customer_card_positive not between", value1, value2, "customerCardPositive");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterIsNull() {
            addCriterion("customer_card_counter is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterIsNotNull() {
            addCriterion("customer_card_counter is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterEqualTo(String value) {
            addCriterion("customer_card_counter =", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterNotEqualTo(String value) {
            addCriterion("customer_card_counter <>", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterGreaterThan(String value) {
            addCriterion("customer_card_counter >", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterGreaterThanOrEqualTo(String value) {
            addCriterion("customer_card_counter >=", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterLessThan(String value) {
            addCriterion("customer_card_counter <", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterLessThanOrEqualTo(String value) {
            addCriterion("customer_card_counter <=", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterLike(String value) {
            addCriterion("customer_card_counter like", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterNotLike(String value) {
            addCriterion("customer_card_counter not like", value, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterIn(List<String> values) {
            addCriterion("customer_card_counter in", values, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterNotIn(List<String> values) {
            addCriterion("customer_card_counter not in", values, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterBetween(String value1, String value2) {
            addCriterion("customer_card_counter between", value1, value2, "customerCardCounter");
            return (Criteria) this;
        }

        public Criteria andCustomerCardCounterNotBetween(String value1, String value2) {
            addCriterion("customer_card_counter not between", value1, value2, "customerCardCounter");
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

        public Criteria andCustomerPhotoIsNull() {
            addCriterion("customer_photo is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoIsNotNull() {
            addCriterion("customer_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoEqualTo(String value) {
            addCriterion("customer_photo =", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotEqualTo(String value) {
            addCriterion("customer_photo <>", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoGreaterThan(String value) {
            addCriterion("customer_photo >", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("customer_photo >=", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLessThan(String value) {
            addCriterion("customer_photo <", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLessThanOrEqualTo(String value) {
            addCriterion("customer_photo <=", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLike(String value) {
            addCriterion("customer_photo like", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotLike(String value) {
            addCriterion("customer_photo not like", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoIn(List<String> values) {
            addCriterion("customer_photo in", values, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotIn(List<String> values) {
            addCriterion("customer_photo not in", values, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoBetween(String value1, String value2) {
            addCriterion("customer_photo between", value1, value2, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotBetween(String value1, String value2) {
            addCriterion("customer_photo not between", value1, value2, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdIsNull() {
            addCriterion("customer_ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdIsNotNull() {
            addCriterion("customer_ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdEqualTo(String value) {
            addCriterion("customer_ticket_id =", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdNotEqualTo(String value) {
            addCriterion("customer_ticket_id <>", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdGreaterThan(String value) {
            addCriterion("customer_ticket_id >", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("customer_ticket_id >=", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdLessThan(String value) {
            addCriterion("customer_ticket_id <", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdLessThanOrEqualTo(String value) {
            addCriterion("customer_ticket_id <=", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdLike(String value) {
            addCriterion("customer_ticket_id like", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdNotLike(String value) {
            addCriterion("customer_ticket_id not like", value, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdIn(List<String> values) {
            addCriterion("customer_ticket_id in", values, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdNotIn(List<String> values) {
            addCriterion("customer_ticket_id not in", values, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdBetween(String value1, String value2) {
            addCriterion("customer_ticket_id between", value1, value2, "customerTicketId");
            return (Criteria) this;
        }

        public Criteria andCustomerTicketIdNotBetween(String value1, String value2) {
            addCriterion("customer_ticket_id not between", value1, value2, "customerTicketId");
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