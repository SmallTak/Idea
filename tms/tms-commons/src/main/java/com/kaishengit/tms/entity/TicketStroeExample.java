package com.kaishengit.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketStroeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketStroeExample() {
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

        public Criteria andStroeNameIsNull() {
            addCriterion("stroe_name is null");
            return (Criteria) this;
        }

        public Criteria andStroeNameIsNotNull() {
            addCriterion("stroe_name is not null");
            return (Criteria) this;
        }

        public Criteria andStroeNameEqualTo(String value) {
            addCriterion("stroe_name =", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotEqualTo(String value) {
            addCriterion("stroe_name <>", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameGreaterThan(String value) {
            addCriterion("stroe_name >", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_name >=", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameLessThan(String value) {
            addCriterion("stroe_name <", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameLessThanOrEqualTo(String value) {
            addCriterion("stroe_name <=", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameLike(String value) {
            addCriterion("stroe_name like", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotLike(String value) {
            addCriterion("stroe_name not like", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameIn(List<String> values) {
            addCriterion("stroe_name in", values, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotIn(List<String> values) {
            addCriterion("stroe_name not in", values, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameBetween(String value1, String value2) {
            addCriterion("stroe_name between", value1, value2, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotBetween(String value1, String value2) {
            addCriterion("stroe_name not between", value1, value2, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeManagerIsNull() {
            addCriterion("stroe_manager is null");
            return (Criteria) this;
        }

        public Criteria andStroeManagerIsNotNull() {
            addCriterion("stroe_manager is not null");
            return (Criteria) this;
        }

        public Criteria andStroeManagerEqualTo(String value) {
            addCriterion("stroe_manager =", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerNotEqualTo(String value) {
            addCriterion("stroe_manager <>", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerGreaterThan(String value) {
            addCriterion("stroe_manager >", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_manager >=", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerLessThan(String value) {
            addCriterion("stroe_manager <", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerLessThanOrEqualTo(String value) {
            addCriterion("stroe_manager <=", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerLike(String value) {
            addCriterion("stroe_manager like", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerNotLike(String value) {
            addCriterion("stroe_manager not like", value, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerIn(List<String> values) {
            addCriterion("stroe_manager in", values, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerNotIn(List<String> values) {
            addCriterion("stroe_manager not in", values, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerBetween(String value1, String value2) {
            addCriterion("stroe_manager between", value1, value2, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeManagerNotBetween(String value1, String value2) {
            addCriterion("stroe_manager not between", value1, value2, "stroeManager");
            return (Criteria) this;
        }

        public Criteria andStroeMobileIsNull() {
            addCriterion("stroe_mobile is null");
            return (Criteria) this;
        }

        public Criteria andStroeMobileIsNotNull() {
            addCriterion("stroe_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andStroeMobileEqualTo(String value) {
            addCriterion("stroe_mobile =", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileNotEqualTo(String value) {
            addCriterion("stroe_mobile <>", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileGreaterThan(String value) {
            addCriterion("stroe_mobile >", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_mobile >=", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileLessThan(String value) {
            addCriterion("stroe_mobile <", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileLessThanOrEqualTo(String value) {
            addCriterion("stroe_mobile <=", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileLike(String value) {
            addCriterion("stroe_mobile like", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileNotLike(String value) {
            addCriterion("stroe_mobile not like", value, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileIn(List<String> values) {
            addCriterion("stroe_mobile in", values, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileNotIn(List<String> values) {
            addCriterion("stroe_mobile not in", values, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileBetween(String value1, String value2) {
            addCriterion("stroe_mobile between", value1, value2, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeMobileNotBetween(String value1, String value2) {
            addCriterion("stroe_mobile not between", value1, value2, "stroeMobile");
            return (Criteria) this;
        }

        public Criteria andStroeAddressIsNull() {
            addCriterion("stroe_address is null");
            return (Criteria) this;
        }

        public Criteria andStroeAddressIsNotNull() {
            addCriterion("stroe_address is not null");
            return (Criteria) this;
        }

        public Criteria andStroeAddressEqualTo(String value) {
            addCriterion("stroe_address =", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressNotEqualTo(String value) {
            addCriterion("stroe_address <>", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressGreaterThan(String value) {
            addCriterion("stroe_address >", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_address >=", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressLessThan(String value) {
            addCriterion("stroe_address <", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressLessThanOrEqualTo(String value) {
            addCriterion("stroe_address <=", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressLike(String value) {
            addCriterion("stroe_address like", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressNotLike(String value) {
            addCriterion("stroe_address not like", value, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressIn(List<String> values) {
            addCriterion("stroe_address in", values, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressNotIn(List<String> values) {
            addCriterion("stroe_address not in", values, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressBetween(String value1, String value2) {
            addCriterion("stroe_address between", value1, value2, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeAddressNotBetween(String value1, String value2) {
            addCriterion("stroe_address not between", value1, value2, "stroeAddress");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeIsNull() {
            addCriterion("stroe_geo_longitude is null");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeIsNotNull() {
            addCriterion("stroe_geo_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeEqualTo(String value) {
            addCriterion("stroe_geo_longitude =", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeNotEqualTo(String value) {
            addCriterion("stroe_geo_longitude <>", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeGreaterThan(String value) {
            addCriterion("stroe_geo_longitude >", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_geo_longitude >=", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeLessThan(String value) {
            addCriterion("stroe_geo_longitude <", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeLessThanOrEqualTo(String value) {
            addCriterion("stroe_geo_longitude <=", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeLike(String value) {
            addCriterion("stroe_geo_longitude like", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeNotLike(String value) {
            addCriterion("stroe_geo_longitude not like", value, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeIn(List<String> values) {
            addCriterion("stroe_geo_longitude in", values, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeNotIn(List<String> values) {
            addCriterion("stroe_geo_longitude not in", values, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeBetween(String value1, String value2) {
            addCriterion("stroe_geo_longitude between", value1, value2, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLongitudeNotBetween(String value1, String value2) {
            addCriterion("stroe_geo_longitude not between", value1, value2, "stroeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeIsNull() {
            addCriterion("stroe_geo_latitude is null");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeIsNotNull() {
            addCriterion("stroe_geo_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeEqualTo(String value) {
            addCriterion("stroe_geo_latitude =", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeNotEqualTo(String value) {
            addCriterion("stroe_geo_latitude <>", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeGreaterThan(String value) {
            addCriterion("stroe_geo_latitude >", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_geo_latitude >=", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeLessThan(String value) {
            addCriterion("stroe_geo_latitude <", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeLessThanOrEqualTo(String value) {
            addCriterion("stroe_geo_latitude <=", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeLike(String value) {
            addCriterion("stroe_geo_latitude like", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeNotLike(String value) {
            addCriterion("stroe_geo_latitude not like", value, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeIn(List<String> values) {
            addCriterion("stroe_geo_latitude in", values, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeNotIn(List<String> values) {
            addCriterion("stroe_geo_latitude not in", values, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeBetween(String value1, String value2) {
            addCriterion("stroe_geo_latitude between", value1, value2, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeGeoLatitudeNotBetween(String value1, String value2) {
            addCriterion("stroe_geo_latitude not between", value1, value2, "stroeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentIsNull() {
            addCriterion("stroe_attachment is null");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentIsNotNull() {
            addCriterion("stroe_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentEqualTo(String value) {
            addCriterion("stroe_attachment =", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentNotEqualTo(String value) {
            addCriterion("stroe_attachment <>", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentGreaterThan(String value) {
            addCriterion("stroe_attachment >", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_attachment >=", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentLessThan(String value) {
            addCriterion("stroe_attachment <", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentLessThanOrEqualTo(String value) {
            addCriterion("stroe_attachment <=", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentLike(String value) {
            addCriterion("stroe_attachment like", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentNotLike(String value) {
            addCriterion("stroe_attachment not like", value, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentIn(List<String> values) {
            addCriterion("stroe_attachment in", values, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentNotIn(List<String> values) {
            addCriterion("stroe_attachment not in", values, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentBetween(String value1, String value2) {
            addCriterion("stroe_attachment between", value1, value2, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeAttachmentNotBetween(String value1, String value2) {
            addCriterion("stroe_attachment not between", value1, value2, "stroeAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentIsNull() {
            addCriterion("stroe_manager_attachment is null");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentIsNotNull() {
            addCriterion("stroe_manager_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentEqualTo(String value) {
            addCriterion("stroe_manager_attachment =", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentNotEqualTo(String value) {
            addCriterion("stroe_manager_attachment <>", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentGreaterThan(String value) {
            addCriterion("stroe_manager_attachment >", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_manager_attachment >=", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentLessThan(String value) {
            addCriterion("stroe_manager_attachment <", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentLessThanOrEqualTo(String value) {
            addCriterion("stroe_manager_attachment <=", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentLike(String value) {
            addCriterion("stroe_manager_attachment like", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentNotLike(String value) {
            addCriterion("stroe_manager_attachment not like", value, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentIn(List<String> values) {
            addCriterion("stroe_manager_attachment in", values, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentNotIn(List<String> values) {
            addCriterion("stroe_manager_attachment not in", values, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentBetween(String value1, String value2) {
            addCriterion("stroe_manager_attachment between", value1, value2, "stroeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStroeManagerAttachmentNotBetween(String value1, String value2) {
            addCriterion("stroe_manager_attachment not between", value1, value2, "stroeManagerAttachment");
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