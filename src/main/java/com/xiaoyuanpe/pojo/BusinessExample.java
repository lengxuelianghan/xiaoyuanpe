package com.xiaoyuanpe.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessExample() {
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

        public Criteria andBueinesNameIsNull() {
            addCriterion("bueines_name is null");
            return (Criteria) this;
        }

        public Criteria andBueinesNameIsNotNull() {
            addCriterion("bueines_name is not null");
            return (Criteria) this;
        }

        public Criteria andBueinesNameEqualTo(String value) {
            addCriterion("bueines_name =", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameNotEqualTo(String value) {
            addCriterion("bueines_name <>", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameGreaterThan(String value) {
            addCriterion("bueines_name >", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameGreaterThanOrEqualTo(String value) {
            addCriterion("bueines_name >=", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameLessThan(String value) {
            addCriterion("bueines_name <", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameLessThanOrEqualTo(String value) {
            addCriterion("bueines_name <=", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameLike(String value) {
            addCriterion("bueines_name like", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameNotLike(String value) {
            addCriterion("bueines_name not like", value, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameIn(List<String> values) {
            addCriterion("bueines_name in", values, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameNotIn(List<String> values) {
            addCriterion("bueines_name not in", values, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameBetween(String value1, String value2) {
            addCriterion("bueines_name between", value1, value2, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andBueinesNameNotBetween(String value1, String value2) {
            addCriterion("bueines_name not between", value1, value2, "bueinesName");
            return (Criteria) this;
        }

        public Criteria andUserlIdIsNull() {
            addCriterion("userl_id is null");
            return (Criteria) this;
        }

        public Criteria andUserlIdIsNotNull() {
            addCriterion("userl_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserlIdEqualTo(Integer value) {
            addCriterion("userl_id =", value, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdNotEqualTo(Integer value) {
            addCriterion("userl_id <>", value, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdGreaterThan(Integer value) {
            addCriterion("userl_id >", value, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userl_id >=", value, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdLessThan(Integer value) {
            addCriterion("userl_id <", value, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdLessThanOrEqualTo(Integer value) {
            addCriterion("userl_id <=", value, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdIn(List<Integer> values) {
            addCriterion("userl_id in", values, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdNotIn(List<Integer> values) {
            addCriterion("userl_id not in", values, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdBetween(Integer value1, Integer value2) {
            addCriterion("userl_id between", value1, value2, "userlId");
            return (Criteria) this;
        }

        public Criteria andUserlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userl_id not between", value1, value2, "userlId");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceIsNull() {
            addCriterion("bueines_price is null");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceIsNotNull() {
            addCriterion("bueines_price is not null");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceEqualTo(BigDecimal value) {
            addCriterion("bueines_price =", value, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceNotEqualTo(BigDecimal value) {
            addCriterion("bueines_price <>", value, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceGreaterThan(BigDecimal value) {
            addCriterion("bueines_price >", value, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bueines_price >=", value, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceLessThan(BigDecimal value) {
            addCriterion("bueines_price <", value, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bueines_price <=", value, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceIn(List<BigDecimal> values) {
            addCriterion("bueines_price in", values, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceNotIn(List<BigDecimal> values) {
            addCriterion("bueines_price not in", values, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bueines_price between", value1, value2, "bueinesPrice");
            return (Criteria) this;
        }

        public Criteria andBueinesPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bueines_price not between", value1, value2, "bueinesPrice");
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