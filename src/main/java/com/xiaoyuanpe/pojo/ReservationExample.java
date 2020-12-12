package com.xiaoyuanpe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReservationExample() {
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

        public Criteria andSportvenueIdIsNull() {
            addCriterion("sportvenue_id is null");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdIsNotNull() {
            addCriterion("sportvenue_id is not null");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdEqualTo(Integer value) {
            addCriterion("sportvenue_id =", value, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdNotEqualTo(Integer value) {
            addCriterion("sportvenue_id <>", value, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdGreaterThan(Integer value) {
            addCriterion("sportvenue_id >", value, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sportvenue_id >=", value, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdLessThan(Integer value) {
            addCriterion("sportvenue_id <", value, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdLessThanOrEqualTo(Integer value) {
            addCriterion("sportvenue_id <=", value, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdIn(List<Integer> values) {
            addCriterion("sportvenue_id in", values, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdNotIn(List<Integer> values) {
            addCriterion("sportvenue_id not in", values, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdBetween(Integer value1, Integer value2) {
            addCriterion("sportvenue_id between", value1, value2, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSportvenueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sportvenue_id not between", value1, value2, "sportvenueId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdIsNull() {
            addCriterion("space_id is null");
            return (Criteria) this;
        }

        public Criteria andSpaceIdIsNotNull() {
            addCriterion("space_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceIdEqualTo(Integer value) {
            addCriterion("space_id =", value, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdNotEqualTo(Integer value) {
            addCriterion("space_id <>", value, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdGreaterThan(Integer value) {
            addCriterion("space_id >", value, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("space_id >=", value, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdLessThan(Integer value) {
            addCriterion("space_id <", value, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdLessThanOrEqualTo(Integer value) {
            addCriterion("space_id <=", value, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdIn(List<Integer> values) {
            addCriterion("space_id in", values, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdNotIn(List<Integer> values) {
            addCriterion("space_id not in", values, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdBetween(Integer value1, Integer value2) {
            addCriterion("space_id between", value1, value2, "spaceId");
            return (Criteria) this;
        }

        public Criteria andSpaceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("space_id not between", value1, value2, "spaceId");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHourIndexIsNull() {
            addCriterion("hour_index is null");
            return (Criteria) this;
        }

        public Criteria andHourIndexIsNotNull() {
            addCriterion("hour_index is not null");
            return (Criteria) this;
        }

        public Criteria andHourIndexEqualTo(Integer value) {
            addCriterion("hour_index =", value, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexNotEqualTo(Integer value) {
            addCriterion("hour_index <>", value, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexGreaterThan(Integer value) {
            addCriterion("hour_index >", value, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("hour_index >=", value, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexLessThan(Integer value) {
            addCriterion("hour_index <", value, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexLessThanOrEqualTo(Integer value) {
            addCriterion("hour_index <=", value, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexIn(List<Integer> values) {
            addCriterion("hour_index in", values, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexNotIn(List<Integer> values) {
            addCriterion("hour_index not in", values, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexBetween(Integer value1, Integer value2) {
            addCriterion("hour_index between", value1, value2, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andHourIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("hour_index not between", value1, value2, "hourIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexIsNull() {
            addCriterion("day_index is null");
            return (Criteria) this;
        }

        public Criteria andDayIndexIsNotNull() {
            addCriterion("day_index is not null");
            return (Criteria) this;
        }

        public Criteria andDayIndexEqualTo(Integer value) {
            addCriterion("day_index =", value, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexNotEqualTo(Integer value) {
            addCriterion("day_index <>", value, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexGreaterThan(Integer value) {
            addCriterion("day_index >", value, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_index >=", value, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexLessThan(Integer value) {
            addCriterion("day_index <", value, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexLessThanOrEqualTo(Integer value) {
            addCriterion("day_index <=", value, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexIn(List<Integer> values) {
            addCriterion("day_index in", values, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexNotIn(List<Integer> values) {
            addCriterion("day_index not in", values, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexBetween(Integer value1, Integer value2) {
            addCriterion("day_index between", value1, value2, "dayIndex");
            return (Criteria) this;
        }

        public Criteria andDayIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("day_index not between", value1, value2, "dayIndex");
            return (Criteria) this;
        }
    }

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