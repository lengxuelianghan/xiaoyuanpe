package com.xiaoyuanpe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNull() {
            addCriterion("activity_content is null");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNotNull() {
            addCriterion("activity_content is not null");
            return (Criteria) this;
        }

        public Criteria andActivityContentEqualTo(String value) {
            addCriterion("activity_content =", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotEqualTo(String value) {
            addCriterion("activity_content <>", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThan(String value) {
            addCriterion("activity_content >", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThanOrEqualTo(String value) {
            addCriterion("activity_content >=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThan(String value) {
            addCriterion("activity_content <", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThanOrEqualTo(String value) {
            addCriterion("activity_content <=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLike(String value) {
            addCriterion("activity_content like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotLike(String value) {
            addCriterion("activity_content not like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentIn(List<String> values) {
            addCriterion("activity_content in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotIn(List<String> values) {
            addCriterion("activity_content not in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentBetween(String value1, String value2) {
            addCriterion("activity_content between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotBetween(String value1, String value2) {
            addCriterion("activity_content not between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNull() {
            addCriterion("publisher_id is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNotNull() {
            addCriterion("publisher_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdEqualTo(Integer value) {
            addCriterion("publisher_id =", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotEqualTo(Integer value) {
            addCriterion("publisher_id <>", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThan(Integer value) {
            addCriterion("publisher_id >", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisher_id >=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThan(Integer value) {
            addCriterion("publisher_id <", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThanOrEqualTo(Integer value) {
            addCriterion("publisher_id <=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIn(List<Integer> values) {
            addCriterion("publisher_id in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotIn(List<Integer> values) {
            addCriterion("publisher_id not in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id not between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublishDataIsNull() {
            addCriterion("publish_data is null");
            return (Criteria) this;
        }

        public Criteria andPublishDataIsNotNull() {
            addCriterion("publish_data is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDataEqualTo(Date value) {
            addCriterion("publish_data =", value, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataNotEqualTo(Date value) {
            addCriterion("publish_data <>", value, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataGreaterThan(Date value) {
            addCriterion("publish_data >", value, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_data >=", value, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataLessThan(Date value) {
            addCriterion("publish_data <", value, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataLessThanOrEqualTo(Date value) {
            addCriterion("publish_data <=", value, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataIn(List<Date> values) {
            addCriterion("publish_data in", values, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataNotIn(List<Date> values) {
            addCriterion("publish_data not in", values, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataBetween(Date value1, Date value2) {
            addCriterion("publish_data between", value1, value2, "publishData");
            return (Criteria) this;
        }

        public Criteria andPublishDataNotBetween(Date value1, Date value2) {
            addCriterion("publish_data not between", value1, value2, "publishData");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Integer value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Integer value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Integer value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Integer value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Integer> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Integer> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Integer value1, Integer value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(Integer value) {
            addCriterion("college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(Integer value) {
            addCriterion("college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(Integer value) {
            addCriterion("college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(Integer value) {
            addCriterion("college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(Integer value) {
            addCriterion("college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<Integer> values) {
            addCriterion("college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<Integer> values) {
            addCriterion("college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(Integer value1, Integer value2) {
            addCriterion("college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("college_id not between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeIsNull() {
            addCriterion("registration_closing_time is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeIsNotNull() {
            addCriterion("registration_closing_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeEqualTo(Date value) {
            addCriterion("registration_closing_time =", value, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeNotEqualTo(Date value) {
            addCriterion("registration_closing_time <>", value, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeGreaterThan(Date value) {
            addCriterion("registration_closing_time >", value, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registration_closing_time >=", value, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeLessThan(Date value) {
            addCriterion("registration_closing_time <", value, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeLessThanOrEqualTo(Date value) {
            addCriterion("registration_closing_time <=", value, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeIn(List<Date> values) {
            addCriterion("registration_closing_time in", values, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeNotIn(List<Date> values) {
            addCriterion("registration_closing_time not in", values, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeBetween(Date value1, Date value2) {
            addCriterion("registration_closing_time between", value1, value2, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationClosingTimeNotBetween(Date value1, Date value2) {
            addCriterion("registration_closing_time not between", value1, value2, "registrationClosingTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeIsNull() {
            addCriterion("registration_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeIsNotNull() {
            addCriterion("registration_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeEqualTo(Date value) {
            addCriterion("registration_start_time =", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeNotEqualTo(Date value) {
            addCriterion("registration_start_time <>", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeGreaterThan(Date value) {
            addCriterion("registration_start_time >", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registration_start_time >=", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeLessThan(Date value) {
            addCriterion("registration_start_time <", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("registration_start_time <=", value, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeIn(List<Date> values) {
            addCriterion("registration_start_time in", values, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeNotIn(List<Date> values) {
            addCriterion("registration_start_time not in", values, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeBetween(Date value1, Date value2) {
            addCriterion("registration_start_time between", value1, value2, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andRegistrationStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("registration_start_time not between", value1, value2, "registrationStartTime");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIsNull() {
            addCriterion("reviewer_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIsNotNull() {
            addCriterion("reviewer_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerIdEqualTo(String value) {
            addCriterion("reviewer_id =", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotEqualTo(String value) {
            addCriterion("reviewer_id <>", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdGreaterThan(String value) {
            addCriterion("reviewer_id >", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdGreaterThanOrEqualTo(String value) {
            addCriterion("reviewer_id >=", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdLessThan(String value) {
            addCriterion("reviewer_id <", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdLessThanOrEqualTo(String value) {
            addCriterion("reviewer_id <=", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdLike(String value) {
            addCriterion("reviewer_id like", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotLike(String value) {
            addCriterion("reviewer_id not like", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIn(List<String> values) {
            addCriterion("reviewer_id in", values, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotIn(List<String> values) {
            addCriterion("reviewer_id not in", values, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdBetween(String value1, String value2) {
            addCriterion("reviewer_id between", value1, value2, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotBetween(String value1, String value2) {
            addCriterion("reviewer_id not between", value1, value2, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationIsNull() {
            addCriterion("way_registration is null");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationIsNotNull() {
            addCriterion("way_registration is not null");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationEqualTo(String value) {
            addCriterion("way_registration =", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationNotEqualTo(String value) {
            addCriterion("way_registration <>", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationGreaterThan(String value) {
            addCriterion("way_registration >", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationGreaterThanOrEqualTo(String value) {
            addCriterion("way_registration >=", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationLessThan(String value) {
            addCriterion("way_registration <", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationLessThanOrEqualTo(String value) {
            addCriterion("way_registration <=", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationLike(String value) {
            addCriterion("way_registration like", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationNotLike(String value) {
            addCriterion("way_registration not like", value, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationIn(List<String> values) {
            addCriterion("way_registration in", values, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationNotIn(List<String> values) {
            addCriterion("way_registration not in", values, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationBetween(String value1, String value2) {
            addCriterion("way_registration between", value1, value2, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andWayRegistrationNotBetween(String value1, String value2) {
            addCriterion("way_registration not between", value1, value2, "wayRegistration");
            return (Criteria) this;
        }

        public Criteria andActivityAreaIsNull() {
            addCriterion("activity_area is null");
            return (Criteria) this;
        }

        public Criteria andActivityAreaIsNotNull() {
            addCriterion("activity_area is not null");
            return (Criteria) this;
        }

        public Criteria andActivityAreaEqualTo(String value) {
            addCriterion("activity_area =", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaNotEqualTo(String value) {
            addCriterion("activity_area <>", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaGreaterThan(String value) {
            addCriterion("activity_area >", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaGreaterThanOrEqualTo(String value) {
            addCriterion("activity_area >=", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaLessThan(String value) {
            addCriterion("activity_area <", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaLessThanOrEqualTo(String value) {
            addCriterion("activity_area <=", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaLike(String value) {
            addCriterion("activity_area like", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaNotLike(String value) {
            addCriterion("activity_area not like", value, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaIn(List<String> values) {
            addCriterion("activity_area in", values, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaNotIn(List<String> values) {
            addCriterion("activity_area not in", values, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaBetween(String value1, String value2) {
            addCriterion("activity_area between", value1, value2, "activityArea");
            return (Criteria) this;
        }

        public Criteria andActivityAreaNotBetween(String value1, String value2) {
            addCriterion("activity_area not between", value1, value2, "activityArea");
            return (Criteria) this;
        }

        public Criteria andEventLocationIsNull() {
            addCriterion("event_location is null");
            return (Criteria) this;
        }

        public Criteria andEventLocationIsNotNull() {
            addCriterion("event_location is not null");
            return (Criteria) this;
        }

        public Criteria andEventLocationEqualTo(String value) {
            addCriterion("event_location =", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationNotEqualTo(String value) {
            addCriterion("event_location <>", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationGreaterThan(String value) {
            addCriterion("event_location >", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationGreaterThanOrEqualTo(String value) {
            addCriterion("event_location >=", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationLessThan(String value) {
            addCriterion("event_location <", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationLessThanOrEqualTo(String value) {
            addCriterion("event_location <=", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationLike(String value) {
            addCriterion("event_location like", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationNotLike(String value) {
            addCriterion("event_location not like", value, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationIn(List<String> values) {
            addCriterion("event_location in", values, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationNotIn(List<String> values) {
            addCriterion("event_location not in", values, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationBetween(String value1, String value2) {
            addCriterion("event_location between", value1, value2, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andEventLocationNotBetween(String value1, String value2) {
            addCriterion("event_location not between", value1, value2, "eventLocation");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationIsNull() {
            addCriterion("activity_classification is null");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationIsNotNull() {
            addCriterion("activity_classification is not null");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationEqualTo(String value) {
            addCriterion("activity_classification =", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationNotEqualTo(String value) {
            addCriterion("activity_classification <>", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationGreaterThan(String value) {
            addCriterion("activity_classification >", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("activity_classification >=", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationLessThan(String value) {
            addCriterion("activity_classification <", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationLessThanOrEqualTo(String value) {
            addCriterion("activity_classification <=", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationLike(String value) {
            addCriterion("activity_classification like", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationNotLike(String value) {
            addCriterion("activity_classification not like", value, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationIn(List<String> values) {
            addCriterion("activity_classification in", values, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationNotIn(List<String> values) {
            addCriterion("activity_classification not in", values, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationBetween(String value1, String value2) {
            addCriterion("activity_classification between", value1, value2, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andActivityClassificationNotBetween(String value1, String value2) {
            addCriterion("activity_classification not between", value1, value2, "activityClassification");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeIsNull() {
            addCriterion("participation_fee is null");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeIsNotNull() {
            addCriterion("participation_fee is not null");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeEqualTo(String value) {
            addCriterion("participation_fee =", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeNotEqualTo(String value) {
            addCriterion("participation_fee <>", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeGreaterThan(String value) {
            addCriterion("participation_fee >", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeGreaterThanOrEqualTo(String value) {
            addCriterion("participation_fee >=", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeLessThan(String value) {
            addCriterion("participation_fee <", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeLessThanOrEqualTo(String value) {
            addCriterion("participation_fee <=", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeLike(String value) {
            addCriterion("participation_fee like", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeNotLike(String value) {
            addCriterion("participation_fee not like", value, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeIn(List<String> values) {
            addCriterion("participation_fee in", values, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeNotIn(List<String> values) {
            addCriterion("participation_fee not in", values, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeBetween(String value1, String value2) {
            addCriterion("participation_fee between", value1, value2, "participationFee");
            return (Criteria) this;
        }

        public Criteria andParticipationFeeNotBetween(String value1, String value2) {
            addCriterion("participation_fee not between", value1, value2, "participationFee");
            return (Criteria) this;
        }

        public Criteria andCollegeListIsNull() {
            addCriterion("college_list is null");
            return (Criteria) this;
        }

        public Criteria andCollegeListIsNotNull() {
            addCriterion("college_list is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeListEqualTo(String value) {
            addCriterion("college_list =", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListNotEqualTo(String value) {
            addCriterion("college_list <>", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListGreaterThan(String value) {
            addCriterion("college_list >", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListGreaterThanOrEqualTo(String value) {
            addCriterion("college_list >=", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListLessThan(String value) {
            addCriterion("college_list <", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListLessThanOrEqualTo(String value) {
            addCriterion("college_list <=", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListLike(String value) {
            addCriterion("college_list like", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListNotLike(String value) {
            addCriterion("college_list not like", value, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListIn(List<String> values) {
            addCriterion("college_list in", values, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListNotIn(List<String> values) {
            addCriterion("college_list not in", values, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListBetween(String value1, String value2) {
            addCriterion("college_list between", value1, value2, "collegeList");
            return (Criteria) this;
        }

        public Criteria andCollegeListNotBetween(String value1, String value2) {
            addCriterion("college_list not between", value1, value2, "collegeList");
            return (Criteria) this;
        }

        public Criteria andClassListIsNull() {
            addCriterion("class_list is null");
            return (Criteria) this;
        }

        public Criteria andClassListIsNotNull() {
            addCriterion("class_list is not null");
            return (Criteria) this;
        }

        public Criteria andClassListEqualTo(String value) {
            addCriterion("class_list =", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListNotEqualTo(String value) {
            addCriterion("class_list <>", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListGreaterThan(String value) {
            addCriterion("class_list >", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListGreaterThanOrEqualTo(String value) {
            addCriterion("class_list >=", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListLessThan(String value) {
            addCriterion("class_list <", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListLessThanOrEqualTo(String value) {
            addCriterion("class_list <=", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListLike(String value) {
            addCriterion("class_list like", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListNotLike(String value) {
            addCriterion("class_list not like", value, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListIn(List<String> values) {
            addCriterion("class_list in", values, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListNotIn(List<String> values) {
            addCriterion("class_list not in", values, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListBetween(String value1, String value2) {
            addCriterion("class_list between", value1, value2, "classList");
            return (Criteria) this;
        }

        public Criteria andClassListNotBetween(String value1, String value2) {
            addCriterion("class_list not between", value1, value2, "classList");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIsNull() {
            addCriterion("people_num is null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIsNotNull() {
            addCriterion("people_num is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumEqualTo(Integer value) {
            addCriterion("people_num =", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotEqualTo(Integer value) {
            addCriterion("people_num <>", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumGreaterThan(Integer value) {
            addCriterion("people_num >", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_num >=", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumLessThan(Integer value) {
            addCriterion("people_num <", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumLessThanOrEqualTo(Integer value) {
            addCriterion("people_num <=", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIn(List<Integer> values) {
            addCriterion("people_num in", values, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotIn(List<Integer> values) {
            addCriterion("people_num not in", values, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumBetween(Integer value1, Integer value2) {
            addCriterion("people_num between", value1, value2, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("people_num not between", value1, value2, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andSignoutIsNull() {
            addCriterion("signout is null");
            return (Criteria) this;
        }

        public Criteria andSignoutIsNotNull() {
            addCriterion("signout is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutEqualTo(String value) {
            addCriterion("signout =", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutNotEqualTo(String value) {
            addCriterion("signout <>", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutGreaterThan(String value) {
            addCriterion("signout >", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutGreaterThanOrEqualTo(String value) {
            addCriterion("signout >=", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutLessThan(String value) {
            addCriterion("signout <", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutLessThanOrEqualTo(String value) {
            addCriterion("signout <=", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutLike(String value) {
            addCriterion("signout like", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutNotLike(String value) {
            addCriterion("signout not like", value, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutIn(List<String> values) {
            addCriterion("signout in", values, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutNotIn(List<String> values) {
            addCriterion("signout not in", values, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutBetween(String value1, String value2) {
            addCriterion("signout between", value1, value2, "signout");
            return (Criteria) this;
        }

        public Criteria andSignoutNotBetween(String value1, String value2) {
            addCriterion("signout not between", value1, value2, "signout");
            return (Criteria) this;
        }

        public Criteria andFieldClockIsNull() {
            addCriterion("field_clock is null");
            return (Criteria) this;
        }

        public Criteria andFieldClockIsNotNull() {
            addCriterion("field_clock is not null");
            return (Criteria) this;
        }

        public Criteria andFieldClockEqualTo(String value) {
            addCriterion("field_clock =", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockNotEqualTo(String value) {
            addCriterion("field_clock <>", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockGreaterThan(String value) {
            addCriterion("field_clock >", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockGreaterThanOrEqualTo(String value) {
            addCriterion("field_clock >=", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockLessThan(String value) {
            addCriterion("field_clock <", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockLessThanOrEqualTo(String value) {
            addCriterion("field_clock <=", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockLike(String value) {
            addCriterion("field_clock like", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockNotLike(String value) {
            addCriterion("field_clock not like", value, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockIn(List<String> values) {
            addCriterion("field_clock in", values, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockNotIn(List<String> values) {
            addCriterion("field_clock not in", values, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockBetween(String value1, String value2) {
            addCriterion("field_clock between", value1, value2, "fieldClock");
            return (Criteria) this;
        }

        public Criteria andFieldClockNotBetween(String value1, String value2) {
            addCriterion("field_clock not between", value1, value2, "fieldClock");
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