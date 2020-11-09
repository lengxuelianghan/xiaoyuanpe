package com.xiaoyuanpe.pojo;

import java.util.ArrayList;
import java.util.List;

public class HealthmanagementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HealthmanagementExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andLungcapacityIsNull() {
            addCriterion("lungcapacity is null");
            return (Criteria) this;
        }

        public Criteria andLungcapacityIsNotNull() {
            addCriterion("lungcapacity is not null");
            return (Criteria) this;
        }

        public Criteria andLungcapacityEqualTo(Integer value) {
            addCriterion("lungcapacity =", value, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityNotEqualTo(Integer value) {
            addCriterion("lungcapacity <>", value, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityGreaterThan(Integer value) {
            addCriterion("lungcapacity >", value, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("lungcapacity >=", value, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityLessThan(Integer value) {
            addCriterion("lungcapacity <", value, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityLessThanOrEqualTo(Integer value) {
            addCriterion("lungcapacity <=", value, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityIn(List<Integer> values) {
            addCriterion("lungcapacity in", values, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityNotIn(List<Integer> values) {
            addCriterion("lungcapacity not in", values, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityBetween(Integer value1, Integer value2) {
            addCriterion("lungcapacity between", value1, value2, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andLungcapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("lungcapacity not between", value1, value2, "lungcapacity");
            return (Criteria) this;
        }

        public Criteria andKilometreIsNull() {
            addCriterion("kilometre is null");
            return (Criteria) this;
        }

        public Criteria andKilometreIsNotNull() {
            addCriterion("kilometre is not null");
            return (Criteria) this;
        }

        public Criteria andKilometreEqualTo(Float value) {
            addCriterion("kilometre =", value, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreNotEqualTo(Float value) {
            addCriterion("kilometre <>", value, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreGreaterThan(Float value) {
            addCriterion("kilometre >", value, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreGreaterThanOrEqualTo(Float value) {
            addCriterion("kilometre >=", value, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreLessThan(Float value) {
            addCriterion("kilometre <", value, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreLessThanOrEqualTo(Float value) {
            addCriterion("kilometre <=", value, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreIn(List<Float> values) {
            addCriterion("kilometre in", values, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreNotIn(List<Float> values) {
            addCriterion("kilometre not in", values, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreBetween(Float value1, Float value2) {
            addCriterion("kilometre between", value1, value2, "kilometre");
            return (Criteria) this;
        }

        public Criteria andKilometreNotBetween(Float value1, Float value2) {
            addCriterion("kilometre not between", value1, value2, "kilometre");
            return (Criteria) this;
        }

        public Criteria andSteptestIsNull() {
            addCriterion("steptest is null");
            return (Criteria) this;
        }

        public Criteria andSteptestIsNotNull() {
            addCriterion("steptest is not null");
            return (Criteria) this;
        }

        public Criteria andSteptestEqualTo(Integer value) {
            addCriterion("steptest =", value, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestNotEqualTo(Integer value) {
            addCriterion("steptest <>", value, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestGreaterThan(Integer value) {
            addCriterion("steptest >", value, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestGreaterThanOrEqualTo(Integer value) {
            addCriterion("steptest >=", value, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestLessThan(Integer value) {
            addCriterion("steptest <", value, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestLessThanOrEqualTo(Integer value) {
            addCriterion("steptest <=", value, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestIn(List<Integer> values) {
            addCriterion("steptest in", values, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestNotIn(List<Integer> values) {
            addCriterion("steptest not in", values, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestBetween(Integer value1, Integer value2) {
            addCriterion("steptest between", value1, value2, "steptest");
            return (Criteria) this;
        }

        public Criteria andSteptestNotBetween(Integer value1, Integer value2) {
            addCriterion("steptest not between", value1, value2, "steptest");
            return (Criteria) this;
        }

        public Criteria andFiftymetersIsNull() {
            addCriterion("fiftymeters is null");
            return (Criteria) this;
        }

        public Criteria andFiftymetersIsNotNull() {
            addCriterion("fiftymeters is not null");
            return (Criteria) this;
        }

        public Criteria andFiftymetersEqualTo(Integer value) {
            addCriterion("fiftymeters =", value, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersNotEqualTo(Integer value) {
            addCriterion("fiftymeters <>", value, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersGreaterThan(Integer value) {
            addCriterion("fiftymeters >", value, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersGreaterThanOrEqualTo(Integer value) {
            addCriterion("fiftymeters >=", value, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersLessThan(Integer value) {
            addCriterion("fiftymeters <", value, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersLessThanOrEqualTo(Integer value) {
            addCriterion("fiftymeters <=", value, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersIn(List<Integer> values) {
            addCriterion("fiftymeters in", values, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersNotIn(List<Integer> values) {
            addCriterion("fiftymeters not in", values, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersBetween(Integer value1, Integer value2) {
            addCriterion("fiftymeters between", value1, value2, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andFiftymetersNotBetween(Integer value1, Integer value2) {
            addCriterion("fiftymeters not between", value1, value2, "fiftymeters");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpIsNull() {
            addCriterion("standinglongjump is null");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpIsNotNull() {
            addCriterion("standinglongjump is not null");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpEqualTo(Float value) {
            addCriterion("standinglongjump =", value, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpNotEqualTo(Float value) {
            addCriterion("standinglongjump <>", value, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpGreaterThan(Float value) {
            addCriterion("standinglongjump >", value, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpGreaterThanOrEqualTo(Float value) {
            addCriterion("standinglongjump >=", value, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpLessThan(Float value) {
            addCriterion("standinglongjump <", value, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpLessThanOrEqualTo(Float value) {
            addCriterion("standinglongjump <=", value, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpIn(List<Float> values) {
            addCriterion("standinglongjump in", values, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpNotIn(List<Float> values) {
            addCriterion("standinglongjump not in", values, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpBetween(Float value1, Float value2) {
            addCriterion("standinglongjump between", value1, value2, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andStandinglongjumpNotBetween(Float value1, Float value2) {
            addCriterion("standinglongjump not between", value1, value2, "standinglongjump");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereIsNull() {
            addCriterion("throwsolidsphere is null");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereIsNotNull() {
            addCriterion("throwsolidsphere is not null");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereEqualTo(Float value) {
            addCriterion("throwsolidsphere =", value, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereNotEqualTo(Float value) {
            addCriterion("throwsolidsphere <>", value, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereGreaterThan(Float value) {
            addCriterion("throwsolidsphere >", value, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereGreaterThanOrEqualTo(Float value) {
            addCriterion("throwsolidsphere >=", value, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereLessThan(Float value) {
            addCriterion("throwsolidsphere <", value, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereLessThanOrEqualTo(Float value) {
            addCriterion("throwsolidsphere <=", value, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereIn(List<Float> values) {
            addCriterion("throwsolidsphere in", values, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereNotIn(List<Float> values) {
            addCriterion("throwsolidsphere not in", values, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereBetween(Float value1, Float value2) {
            addCriterion("throwsolidsphere between", value1, value2, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andThrowsolidsphereNotBetween(Float value1, Float value2) {
            addCriterion("throwsolidsphere not between", value1, value2, "throwsolidsphere");
            return (Criteria) this;
        }

        public Criteria andGripIsNull() {
            addCriterion("grip is null");
            return (Criteria) this;
        }

        public Criteria andGripIsNotNull() {
            addCriterion("grip is not null");
            return (Criteria) this;
        }

        public Criteria andGripEqualTo(Integer value) {
            addCriterion("grip =", value, "grip");
            return (Criteria) this;
        }

        public Criteria andGripNotEqualTo(Integer value) {
            addCriterion("grip <>", value, "grip");
            return (Criteria) this;
        }

        public Criteria andGripGreaterThan(Integer value) {
            addCriterion("grip >", value, "grip");
            return (Criteria) this;
        }

        public Criteria andGripGreaterThanOrEqualTo(Integer value) {
            addCriterion("grip >=", value, "grip");
            return (Criteria) this;
        }

        public Criteria andGripLessThan(Integer value) {
            addCriterion("grip <", value, "grip");
            return (Criteria) this;
        }

        public Criteria andGripLessThanOrEqualTo(Integer value) {
            addCriterion("grip <=", value, "grip");
            return (Criteria) this;
        }

        public Criteria andGripIn(List<Integer> values) {
            addCriterion("grip in", values, "grip");
            return (Criteria) this;
        }

        public Criteria andGripNotIn(List<Integer> values) {
            addCriterion("grip not in", values, "grip");
            return (Criteria) this;
        }

        public Criteria andGripBetween(Integer value1, Integer value2) {
            addCriterion("grip between", value1, value2, "grip");
            return (Criteria) this;
        }

        public Criteria andGripNotBetween(Integer value1, Integer value2) {
            addCriterion("grip not between", value1, value2, "grip");
            return (Criteria) this;
        }

        public Criteria andPullUpsIsNull() {
            addCriterion("pull_ups is null");
            return (Criteria) this;
        }

        public Criteria andPullUpsIsNotNull() {
            addCriterion("pull_ups is not null");
            return (Criteria) this;
        }

        public Criteria andPullUpsEqualTo(Integer value) {
            addCriterion("pull_ups =", value, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsNotEqualTo(Integer value) {
            addCriterion("pull_ups <>", value, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsGreaterThan(Integer value) {
            addCriterion("pull_ups >", value, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsGreaterThanOrEqualTo(Integer value) {
            addCriterion("pull_ups >=", value, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsLessThan(Integer value) {
            addCriterion("pull_ups <", value, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsLessThanOrEqualTo(Integer value) {
            addCriterion("pull_ups <=", value, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsIn(List<Integer> values) {
            addCriterion("pull_ups in", values, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsNotIn(List<Integer> values) {
            addCriterion("pull_ups not in", values, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsBetween(Integer value1, Integer value2) {
            addCriterion("pull_ups between", value1, value2, "pullUps");
            return (Criteria) this;
        }

        public Criteria andPullUpsNotBetween(Integer value1, Integer value2) {
            addCriterion("pull_ups not between", value1, value2, "pullUps");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingIsNull() {
            addCriterion("sittingforwardbending is null");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingIsNotNull() {
            addCriterion("sittingforwardbending is not null");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingEqualTo(Integer value) {
            addCriterion("sittingforwardbending =", value, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingNotEqualTo(Integer value) {
            addCriterion("sittingforwardbending <>", value, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingGreaterThan(Integer value) {
            addCriterion("sittingforwardbending >", value, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingGreaterThanOrEqualTo(Integer value) {
            addCriterion("sittingforwardbending >=", value, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingLessThan(Integer value) {
            addCriterion("sittingforwardbending <", value, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingLessThanOrEqualTo(Integer value) {
            addCriterion("sittingforwardbending <=", value, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingIn(List<Integer> values) {
            addCriterion("sittingforwardbending in", values, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingNotIn(List<Integer> values) {
            addCriterion("sittingforwardbending not in", values, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingBetween(Integer value1, Integer value2) {
            addCriterion("sittingforwardbending between", value1, value2, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andSittingforwardbendingNotBetween(Integer value1, Integer value2) {
            addCriterion("sittingforwardbending not between", value1, value2, "sittingforwardbending");
            return (Criteria) this;
        }

        public Criteria andRopeskippingIsNull() {
            addCriterion("ropeskipping is null");
            return (Criteria) this;
        }

        public Criteria andRopeskippingIsNotNull() {
            addCriterion("ropeskipping is not null");
            return (Criteria) this;
        }

        public Criteria andRopeskippingEqualTo(Integer value) {
            addCriterion("ropeskipping =", value, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingNotEqualTo(Integer value) {
            addCriterion("ropeskipping <>", value, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingGreaterThan(Integer value) {
            addCriterion("ropeskipping >", value, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingGreaterThanOrEqualTo(Integer value) {
            addCriterion("ropeskipping >=", value, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingLessThan(Integer value) {
            addCriterion("ropeskipping <", value, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingLessThanOrEqualTo(Integer value) {
            addCriterion("ropeskipping <=", value, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingIn(List<Integer> values) {
            addCriterion("ropeskipping in", values, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingNotIn(List<Integer> values) {
            addCriterion("ropeskipping not in", values, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingBetween(Integer value1, Integer value2) {
            addCriterion("ropeskipping between", value1, value2, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andRopeskippingNotBetween(Integer value1, Integer value2) {
            addCriterion("ropeskipping not between", value1, value2, "ropeskipping");
            return (Criteria) this;
        }

        public Criteria andBasketballIsNull() {
            addCriterion("basketball is null");
            return (Criteria) this;
        }

        public Criteria andBasketballIsNotNull() {
            addCriterion("basketball is not null");
            return (Criteria) this;
        }

        public Criteria andBasketballEqualTo(Integer value) {
            addCriterion("basketball =", value, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballNotEqualTo(Integer value) {
            addCriterion("basketball <>", value, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballGreaterThan(Integer value) {
            addCriterion("basketball >", value, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballGreaterThanOrEqualTo(Integer value) {
            addCriterion("basketball >=", value, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballLessThan(Integer value) {
            addCriterion("basketball <", value, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballLessThanOrEqualTo(Integer value) {
            addCriterion("basketball <=", value, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballIn(List<Integer> values) {
            addCriterion("basketball in", values, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballNotIn(List<Integer> values) {
            addCriterion("basketball not in", values, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballBetween(Integer value1, Integer value2) {
            addCriterion("basketball between", value1, value2, "basketball");
            return (Criteria) this;
        }

        public Criteria andBasketballNotBetween(Integer value1, Integer value2) {
            addCriterion("basketball not between", value1, value2, "basketball");
            return (Criteria) this;
        }

        public Criteria andFootballIsNull() {
            addCriterion("football is null");
            return (Criteria) this;
        }

        public Criteria andFootballIsNotNull() {
            addCriterion("football is not null");
            return (Criteria) this;
        }

        public Criteria andFootballEqualTo(Integer value) {
            addCriterion("football =", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballNotEqualTo(Integer value) {
            addCriterion("football <>", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballGreaterThan(Integer value) {
            addCriterion("football >", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballGreaterThanOrEqualTo(Integer value) {
            addCriterion("football >=", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballLessThan(Integer value) {
            addCriterion("football <", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballLessThanOrEqualTo(Integer value) {
            addCriterion("football <=", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballIn(List<Integer> values) {
            addCriterion("football in", values, "football");
            return (Criteria) this;
        }

        public Criteria andFootballNotIn(List<Integer> values) {
            addCriterion("football not in", values, "football");
            return (Criteria) this;
        }

        public Criteria andFootballBetween(Integer value1, Integer value2) {
            addCriterion("football between", value1, value2, "football");
            return (Criteria) this;
        }

        public Criteria andFootballNotBetween(Integer value1, Integer value2) {
            addCriterion("football not between", value1, value2, "football");
            return (Criteria) this;
        }

        public Criteria andVolleyballIsNull() {
            addCriterion("volleyball is null");
            return (Criteria) this;
        }

        public Criteria andVolleyballIsNotNull() {
            addCriterion("volleyball is not null");
            return (Criteria) this;
        }

        public Criteria andVolleyballEqualTo(Integer value) {
            addCriterion("volleyball =", value, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballNotEqualTo(Integer value) {
            addCriterion("volleyball <>", value, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballGreaterThan(Integer value) {
            addCriterion("volleyball >", value, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballGreaterThanOrEqualTo(Integer value) {
            addCriterion("volleyball >=", value, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballLessThan(Integer value) {
            addCriterion("volleyball <", value, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballLessThanOrEqualTo(Integer value) {
            addCriterion("volleyball <=", value, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballIn(List<Integer> values) {
            addCriterion("volleyball in", values, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballNotIn(List<Integer> values) {
            addCriterion("volleyball not in", values, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballBetween(Integer value1, Integer value2) {
            addCriterion("volleyball between", value1, value2, "volleyball");
            return (Criteria) this;
        }

        public Criteria andVolleyballNotBetween(Integer value1, Integer value2) {
            addCriterion("volleyball not between", value1, value2, "volleyball");
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