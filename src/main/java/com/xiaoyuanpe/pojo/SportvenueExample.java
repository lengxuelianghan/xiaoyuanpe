package com.xiaoyuanpe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportvenueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportvenueExample() {
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

        public Criteria andSportNameIsNull() {
            addCriterion("sport_name is null");
            return (Criteria) this;
        }

        public Criteria andSportNameIsNotNull() {
            addCriterion("sport_name is not null");
            return (Criteria) this;
        }

        public Criteria andSportNameEqualTo(String value) {
            addCriterion("sport_name =", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameNotEqualTo(String value) {
            addCriterion("sport_name <>", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameGreaterThan(String value) {
            addCriterion("sport_name >", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameGreaterThanOrEqualTo(String value) {
            addCriterion("sport_name >=", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameLessThan(String value) {
            addCriterion("sport_name <", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameLessThanOrEqualTo(String value) {
            addCriterion("sport_name <=", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameLike(String value) {
            addCriterion("sport_name like", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameNotLike(String value) {
            addCriterion("sport_name not like", value, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameIn(List<String> values) {
            addCriterion("sport_name in", values, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameNotIn(List<String> values) {
            addCriterion("sport_name not in", values, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameBetween(String value1, String value2) {
            addCriterion("sport_name between", value1, value2, "sportName");
            return (Criteria) this;
        }

        public Criteria andSportNameNotBetween(String value1, String value2) {
            addCriterion("sport_name not between", value1, value2, "sportName");
            return (Criteria) this;
        }

        public Criteria andSiteSizeIsNull() {
            addCriterion("site_size is null");
            return (Criteria) this;
        }

        public Criteria andSiteSizeIsNotNull() {
            addCriterion("site_size is not null");
            return (Criteria) this;
        }

        public Criteria andSiteSizeEqualTo(Double value) {
            addCriterion("site_size =", value, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeNotEqualTo(Double value) {
            addCriterion("site_size <>", value, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeGreaterThan(Double value) {
            addCriterion("site_size >", value, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("site_size >=", value, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeLessThan(Double value) {
            addCriterion("site_size <", value, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeLessThanOrEqualTo(Double value) {
            addCriterion("site_size <=", value, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeIn(List<Double> values) {
            addCriterion("site_size in", values, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeNotIn(List<Double> values) {
            addCriterion("site_size not in", values, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeBetween(Double value1, Double value2) {
            addCriterion("site_size between", value1, value2, "siteSize");
            return (Criteria) this;
        }

        public Criteria andSiteSizeNotBetween(Double value1, Double value2) {
            addCriterion("site_size not between", value1, value2, "siteSize");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesIsNull() {
            addCriterion("number_venues is null");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesIsNotNull() {
            addCriterion("number_venues is not null");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesEqualTo(Integer value) {
            addCriterion("number_venues =", value, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesNotEqualTo(Integer value) {
            addCriterion("number_venues <>", value, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesGreaterThan(Integer value) {
            addCriterion("number_venues >", value, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_venues >=", value, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesLessThan(Integer value) {
            addCriterion("number_venues <", value, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesLessThanOrEqualTo(Integer value) {
            addCriterion("number_venues <=", value, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesIn(List<Integer> values) {
            addCriterion("number_venues in", values, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesNotIn(List<Integer> values) {
            addCriterion("number_venues not in", values, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesBetween(Integer value1, Integer value2) {
            addCriterion("number_venues between", value1, value2, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andNumberVenuesNotBetween(Integer value1, Integer value2) {
            addCriterion("number_venues not between", value1, value2, "numberVenues");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Double value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Double value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Double value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Double value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Double value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Double> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Double> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Double value1, Double value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Double value1, Double value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeIsNull() {
            addCriterion("construction_time is null");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeIsNotNull() {
            addCriterion("construction_time is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeEqualTo(Date value) {
            addCriterion("construction_time =", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeNotEqualTo(Date value) {
            addCriterion("construction_time <>", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeGreaterThan(Date value) {
            addCriterion("construction_time >", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("construction_time >=", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeLessThan(Date value) {
            addCriterion("construction_time <", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeLessThanOrEqualTo(Date value) {
            addCriterion("construction_time <=", value, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeIn(List<Date> values) {
            addCriterion("construction_time in", values, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeNotIn(List<Date> values) {
            addCriterion("construction_time not in", values, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeBetween(Date value1, Date value2) {
            addCriterion("construction_time between", value1, value2, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andConstructionTimeNotBetween(Date value1, Date value2) {
            addCriterion("construction_time not between", value1, value2, "constructionTime");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andVenueIdIsNull() {
            addCriterion("venue_id is null");
            return (Criteria) this;
        }

        public Criteria andVenueIdIsNotNull() {
            addCriterion("venue_id is not null");
            return (Criteria) this;
        }

        public Criteria andVenueIdEqualTo(Integer value) {
            addCriterion("venue_id =", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotEqualTo(Integer value) {
            addCriterion("venue_id <>", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdGreaterThan(Integer value) {
            addCriterion("venue_id >", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("venue_id >=", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdLessThan(Integer value) {
            addCriterion("venue_id <", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdLessThanOrEqualTo(Integer value) {
            addCriterion("venue_id <=", value, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdIn(List<Integer> values) {
            addCriterion("venue_id in", values, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotIn(List<Integer> values) {
            addCriterion("venue_id not in", values, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdBetween(Integer value1, Integer value2) {
            addCriterion("venue_id between", value1, value2, "venueId");
            return (Criteria) this;
        }

        public Criteria andVenueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("venue_id not between", value1, value2, "venueId");
            return (Criteria) this;
        }

        public Criteria andImgNameIsNull() {
            addCriterion("img_name is null");
            return (Criteria) this;
        }

        public Criteria andImgNameIsNotNull() {
            addCriterion("img_name is not null");
            return (Criteria) this;
        }

        public Criteria andImgNameEqualTo(String value) {
            addCriterion("img_name =", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotEqualTo(String value) {
            addCriterion("img_name <>", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameGreaterThan(String value) {
            addCriterion("img_name >", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("img_name >=", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameLessThan(String value) {
            addCriterion("img_name <", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameLessThanOrEqualTo(String value) {
            addCriterion("img_name <=", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameLike(String value) {
            addCriterion("img_name like", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotLike(String value) {
            addCriterion("img_name not like", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameIn(List<String> values) {
            addCriterion("img_name in", values, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotIn(List<String> values) {
            addCriterion("img_name not in", values, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameBetween(String value1, String value2) {
            addCriterion("img_name between", value1, value2, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotBetween(String value1, String value2) {
            addCriterion("img_name not between", value1, value2, "imgName");
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