package com.xiaoyuanpe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VenueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VenueExample() {
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

        public Criteria andVenueNameIsNull() {
            addCriterion("venue_name is null");
            return (Criteria) this;
        }

        public Criteria andVenueNameIsNotNull() {
            addCriterion("venue_name is not null");
            return (Criteria) this;
        }

        public Criteria andVenueNameEqualTo(String value) {
            addCriterion("venue_name =", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameNotEqualTo(String value) {
            addCriterion("venue_name <>", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameGreaterThan(String value) {
            addCriterion("venue_name >", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameGreaterThanOrEqualTo(String value) {
            addCriterion("venue_name >=", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameLessThan(String value) {
            addCriterion("venue_name <", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameLessThanOrEqualTo(String value) {
            addCriterion("venue_name <=", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameLike(String value) {
            addCriterion("venue_name like", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameNotLike(String value) {
            addCriterion("venue_name not like", value, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameIn(List<String> values) {
            addCriterion("venue_name in", values, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameNotIn(List<String> values) {
            addCriterion("venue_name not in", values, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameBetween(String value1, String value2) {
            addCriterion("venue_name between", value1, value2, "venueName");
            return (Criteria) this;
        }

        public Criteria andVenueNameNotBetween(String value1, String value2) {
            addCriterion("venue_name not between", value1, value2, "venueName");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("Introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("Introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("Introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("Introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("Introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("Introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("Introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("Introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("Introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("Introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("Introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("Introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("Introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("Introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andPerPriceIsNull() {
            addCriterion("per_price is null");
            return (Criteria) this;
        }

        public Criteria andPerPriceIsNotNull() {
            addCriterion("per_price is not null");
            return (Criteria) this;
        }

        public Criteria andPerPriceEqualTo(String value) {
            addCriterion("per_price =", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceNotEqualTo(String value) {
            addCriterion("per_price <>", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceGreaterThan(String value) {
            addCriterion("per_price >", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceGreaterThanOrEqualTo(String value) {
            addCriterion("per_price >=", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceLessThan(String value) {
            addCriterion("per_price <", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceLessThanOrEqualTo(String value) {
            addCriterion("per_price <=", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceLike(String value) {
            addCriterion("per_price like", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceNotLike(String value) {
            addCriterion("per_price not like", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceIn(List<String> values) {
            addCriterion("per_price in", values, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceNotIn(List<String> values) {
            addCriterion("per_price not in", values, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceBetween(String value1, String value2) {
            addCriterion("per_price between", value1, value2, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceNotBetween(String value1, String value2) {
            addCriterion("per_price not between", value1, value2, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartIsNull() {
            addCriterion("closing_date_start is null");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartIsNotNull() {
            addCriterion("closing_date_start is not null");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartEqualTo(Date value) {
            addCriterion("closing_date_start =", value, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartNotEqualTo(Date value) {
            addCriterion("closing_date_start <>", value, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartGreaterThan(Date value) {
            addCriterion("closing_date_start >", value, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartGreaterThanOrEqualTo(Date value) {
            addCriterion("closing_date_start >=", value, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartLessThan(Date value) {
            addCriterion("closing_date_start <", value, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartLessThanOrEqualTo(Date value) {
            addCriterion("closing_date_start <=", value, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartIn(List<Date> values) {
            addCriterion("closing_date_start in", values, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartNotIn(List<Date> values) {
            addCriterion("closing_date_start not in", values, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartBetween(Date value1, Date value2) {
            addCriterion("closing_date_start between", value1, value2, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateStartNotBetween(Date value1, Date value2) {
            addCriterion("closing_date_start not between", value1, value2, "closingDateStart");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndIsNull() {
            addCriterion("closing_date_end is null");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndIsNotNull() {
            addCriterion("closing_date_end is not null");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndEqualTo(Date value) {
            addCriterion("closing_date_end =", value, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndNotEqualTo(Date value) {
            addCriterion("closing_date_end <>", value, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndGreaterThan(Date value) {
            addCriterion("closing_date_end >", value, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndGreaterThanOrEqualTo(Date value) {
            addCriterion("closing_date_end >=", value, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndLessThan(Date value) {
            addCriterion("closing_date_end <", value, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndLessThanOrEqualTo(Date value) {
            addCriterion("closing_date_end <=", value, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndIn(List<Date> values) {
            addCriterion("closing_date_end in", values, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndNotIn(List<Date> values) {
            addCriterion("closing_date_end not in", values, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndBetween(Date value1, Date value2) {
            addCriterion("closing_date_end between", value1, value2, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andClosingDateEndNotBetween(Date value1, Date value2) {
            addCriterion("closing_date_end not between", value1, value2, "closingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartIsNull() {
            addCriterion("opening_date_start is null");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartIsNotNull() {
            addCriterion("opening_date_start is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartEqualTo(Date value) {
            addCriterion("opening_date_start =", value, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartNotEqualTo(Date value) {
            addCriterion("opening_date_start <>", value, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartGreaterThan(Date value) {
            addCriterion("opening_date_start >", value, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartGreaterThanOrEqualTo(Date value) {
            addCriterion("opening_date_start >=", value, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartLessThan(Date value) {
            addCriterion("opening_date_start <", value, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartLessThanOrEqualTo(Date value) {
            addCriterion("opening_date_start <=", value, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartIn(List<Date> values) {
            addCriterion("opening_date_start in", values, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartNotIn(List<Date> values) {
            addCriterion("opening_date_start not in", values, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartBetween(Date value1, Date value2) {
            addCriterion("opening_date_start between", value1, value2, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateStartNotBetween(Date value1, Date value2) {
            addCriterion("opening_date_start not between", value1, value2, "openingDateStart");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndIsNull() {
            addCriterion("opening_date_end is null");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndIsNotNull() {
            addCriterion("opening_date_end is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndEqualTo(Date value) {
            addCriterion("opening_date_end =", value, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndNotEqualTo(Date value) {
            addCriterion("opening_date_end <>", value, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndGreaterThan(Date value) {
            addCriterion("opening_date_end >", value, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndGreaterThanOrEqualTo(Date value) {
            addCriterion("opening_date_end >=", value, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndLessThan(Date value) {
            addCriterion("opening_date_end <", value, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndLessThanOrEqualTo(Date value) {
            addCriterion("opening_date_end <=", value, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndIn(List<Date> values) {
            addCriterion("opening_date_end in", values, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndNotIn(List<Date> values) {
            addCriterion("opening_date_end not in", values, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndBetween(Date value1, Date value2) {
            addCriterion("opening_date_end between", value1, value2, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningDateEndNotBetween(Date value1, Date value2) {
            addCriterion("opening_date_end not between", value1, value2, "openingDateEnd");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeIsNull() {
            addCriterion("opening_time is null");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeIsNotNull() {
            addCriterion("opening_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeEqualTo(String value) {
            addCriterion("opening_time =", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeNotEqualTo(String value) {
            addCriterion("opening_time <>", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeGreaterThan(String value) {
            addCriterion("opening_time >", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeGreaterThanOrEqualTo(String value) {
            addCriterion("opening_time >=", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeLessThan(String value) {
            addCriterion("opening_time <", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeLessThanOrEqualTo(String value) {
            addCriterion("opening_time <=", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeLike(String value) {
            addCriterion("opening_time like", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeNotLike(String value) {
            addCriterion("opening_time not like", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeIn(List<String> values) {
            addCriterion("opening_time in", values, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeNotIn(List<String> values) {
            addCriterion("opening_time not in", values, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeBetween(String value1, String value2) {
            addCriterion("opening_time between", value1, value2, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeNotBetween(String value1, String value2) {
            addCriterion("opening_time not between", value1, value2, "openingTime");
            return (Criteria) this;
        }

        public Criteria andVenueAddrIsNull() {
            addCriterion("venue_addr is null");
            return (Criteria) this;
        }

        public Criteria andVenueAddrIsNotNull() {
            addCriterion("venue_addr is not null");
            return (Criteria) this;
        }

        public Criteria andVenueAddrEqualTo(String value) {
            addCriterion("venue_addr =", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrNotEqualTo(String value) {
            addCriterion("venue_addr <>", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrGreaterThan(String value) {
            addCriterion("venue_addr >", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrGreaterThanOrEqualTo(String value) {
            addCriterion("venue_addr >=", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrLessThan(String value) {
            addCriterion("venue_addr <", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrLessThanOrEqualTo(String value) {
            addCriterion("venue_addr <=", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrLike(String value) {
            addCriterion("venue_addr like", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrNotLike(String value) {
            addCriterion("venue_addr not like", value, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrIn(List<String> values) {
            addCriterion("venue_addr in", values, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrNotIn(List<String> values) {
            addCriterion("venue_addr not in", values, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrBetween(String value1, String value2) {
            addCriterion("venue_addr between", value1, value2, "venueAddr");
            return (Criteria) this;
        }

        public Criteria andVenueAddrNotBetween(String value1, String value2) {
            addCriterion("venue_addr not between", value1, value2, "venueAddr");
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

        public Criteria andTheBusIsNull() {
            addCriterion("the_bus is null");
            return (Criteria) this;
        }

        public Criteria andTheBusIsNotNull() {
            addCriterion("the_bus is not null");
            return (Criteria) this;
        }

        public Criteria andTheBusEqualTo(String value) {
            addCriterion("the_bus =", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusNotEqualTo(String value) {
            addCriterion("the_bus <>", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusGreaterThan(String value) {
            addCriterion("the_bus >", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusGreaterThanOrEqualTo(String value) {
            addCriterion("the_bus >=", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusLessThan(String value) {
            addCriterion("the_bus <", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusLessThanOrEqualTo(String value) {
            addCriterion("the_bus <=", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusLike(String value) {
            addCriterion("the_bus like", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusNotLike(String value) {
            addCriterion("the_bus not like", value, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusIn(List<String> values) {
            addCriterion("the_bus in", values, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusNotIn(List<String> values) {
            addCriterion("the_bus not in", values, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusBetween(String value1, String value2) {
            addCriterion("the_bus between", value1, value2, "theBus");
            return (Criteria) this;
        }

        public Criteria andTheBusNotBetween(String value1, String value2) {
            addCriterion("the_bus not between", value1, value2, "theBus");
            return (Criteria) this;
        }

        public Criteria andSubwayIsNull() {
            addCriterion("subway is null");
            return (Criteria) this;
        }

        public Criteria andSubwayIsNotNull() {
            addCriterion("subway is not null");
            return (Criteria) this;
        }

        public Criteria andSubwayEqualTo(String value) {
            addCriterion("subway =", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotEqualTo(String value) {
            addCriterion("subway <>", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayGreaterThan(String value) {
            addCriterion("subway >", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayGreaterThanOrEqualTo(String value) {
            addCriterion("subway >=", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLessThan(String value) {
            addCriterion("subway <", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLessThanOrEqualTo(String value) {
            addCriterion("subway <=", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLike(String value) {
            addCriterion("subway like", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotLike(String value) {
            addCriterion("subway not like", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayIn(List<String> values) {
            addCriterion("subway in", values, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotIn(List<String> values) {
            addCriterion("subway not in", values, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayBetween(String value1, String value2) {
            addCriterion("subway between", value1, value2, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotBetween(String value1, String value2) {
            addCriterion("subway not between", value1, value2, "subway");
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