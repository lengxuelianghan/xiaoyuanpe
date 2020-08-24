package com.xiaoyuanpe.pojo;

import java.util.ArrayList;
import java.util.List;

public class CollegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollegeExample() {
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

        public Criteria andShcoolIdIsNull() {
            addCriterion("shcool_id is null");
            return (Criteria) this;
        }

        public Criteria andShcoolIdIsNotNull() {
            addCriterion("shcool_id is not null");
            return (Criteria) this;
        }

        public Criteria andShcoolIdEqualTo(Integer value) {
            addCriterion("shcool_id =", value, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdNotEqualTo(Integer value) {
            addCriterion("shcool_id <>", value, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdGreaterThan(Integer value) {
            addCriterion("shcool_id >", value, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shcool_id >=", value, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdLessThan(Integer value) {
            addCriterion("shcool_id <", value, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("shcool_id <=", value, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdIn(List<Integer> values) {
            addCriterion("shcool_id in", values, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdNotIn(List<Integer> values) {
            addCriterion("shcool_id not in", values, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdBetween(Integer value1, Integer value2) {
            addCriterion("shcool_id between", value1, value2, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andShcoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shcool_id not between", value1, value2, "shcoolId");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNull() {
            addCriterion("college_name is null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNotNull() {
            addCriterion("college_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameEqualTo(String value) {
            addCriterion("college_name =", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotEqualTo(String value) {
            addCriterion("college_name <>", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThan(String value) {
            addCriterion("college_name >", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThanOrEqualTo(String value) {
            addCriterion("college_name >=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThan(String value) {
            addCriterion("college_name <", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThanOrEqualTo(String value) {
            addCriterion("college_name <=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLike(String value) {
            addCriterion("college_name like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotLike(String value) {
            addCriterion("college_name not like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIn(List<String> values) {
            addCriterion("college_name in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotIn(List<String> values) {
            addCriterion("college_name not in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameBetween(String value1, String value2) {
            addCriterion("college_name between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotBetween(String value1, String value2) {
            addCriterion("college_name not between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoIsNull() {
            addCriterion("college_info is null");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoIsNotNull() {
            addCriterion("college_info is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoEqualTo(String value) {
            addCriterion("college_info =", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoNotEqualTo(String value) {
            addCriterion("college_info <>", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoGreaterThan(String value) {
            addCriterion("college_info >", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoGreaterThanOrEqualTo(String value) {
            addCriterion("college_info >=", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoLessThan(String value) {
            addCriterion("college_info <", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoLessThanOrEqualTo(String value) {
            addCriterion("college_info <=", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoLike(String value) {
            addCriterion("college_info like", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoNotLike(String value) {
            addCriterion("college_info not like", value, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoIn(List<String> values) {
            addCriterion("college_info in", values, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoNotIn(List<String> values) {
            addCriterion("college_info not in", values, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoBetween(String value1, String value2) {
            addCriterion("college_info between", value1, value2, "collegeInfo");
            return (Criteria) this;
        }

        public Criteria andCollegeInfoNotBetween(String value1, String value2) {
            addCriterion("college_info not between", value1, value2, "collegeInfo");
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