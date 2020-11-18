package com.xiaoyuanpe.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andTeamIsNull() {
            addCriterion("team is null");
            return (Criteria) this;
        }

        public Criteria andTeamIsNotNull() {
            addCriterion("team is not null");
            return (Criteria) this;
        }

        public Criteria andTeamEqualTo(String value) {
            addCriterion("team =", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotEqualTo(String value) {
            addCriterion("team <>", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThan(String value) {
            addCriterion("team >", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThanOrEqualTo(String value) {
            addCriterion("team >=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThan(String value) {
            addCriterion("team <", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThanOrEqualTo(String value) {
            addCriterion("team <=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLike(String value) {
            addCriterion("team like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotLike(String value) {
            addCriterion("team not like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamIn(List<String> values) {
            addCriterion("team in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotIn(List<String> values) {
            addCriterion("team not in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamBetween(String value1, String value2) {
            addCriterion("team between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotBetween(String value1, String value2) {
            addCriterion("team not between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andMaximumIsNull() {
            addCriterion("maximum is null");
            return (Criteria) this;
        }

        public Criteria andMaximumIsNotNull() {
            addCriterion("maximum is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumEqualTo(Integer value) {
            addCriterion("maximum =", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumNotEqualTo(Integer value) {
            addCriterion("maximum <>", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumGreaterThan(Integer value) {
            addCriterion("maximum >", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumGreaterThanOrEqualTo(Integer value) {
            addCriterion("maximum >=", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumLessThan(Integer value) {
            addCriterion("maximum <", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumLessThanOrEqualTo(Integer value) {
            addCriterion("maximum <=", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumIn(List<Integer> values) {
            addCriterion("maximum in", values, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumNotIn(List<Integer> values) {
            addCriterion("maximum not in", values, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumBetween(Integer value1, Integer value2) {
            addCriterion("maximum between", value1, value2, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumNotBetween(Integer value1, Integer value2) {
            addCriterion("maximum not between", value1, value2, "maximum");
            return (Criteria) this;
        }

        public Criteria andIntegralSetIsNull() {
            addCriterion("integral_set is null");
            return (Criteria) this;
        }

        public Criteria andIntegralSetIsNotNull() {
            addCriterion("integral_set is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralSetEqualTo(Integer value) {
            addCriterion("integral_set =", value, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetNotEqualTo(Integer value) {
            addCriterion("integral_set <>", value, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetGreaterThan(Integer value) {
            addCriterion("integral_set >", value, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_set >=", value, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetLessThan(Integer value) {
            addCriterion("integral_set <", value, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetLessThanOrEqualTo(Integer value) {
            addCriterion("integral_set <=", value, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetIn(List<Integer> values) {
            addCriterion("integral_set in", values, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetNotIn(List<Integer> values) {
            addCriterion("integral_set not in", values, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetBetween(Integer value1, Integer value2) {
            addCriterion("integral_set between", value1, value2, "integralSet");
            return (Criteria) this;
        }

        public Criteria andIntegralSetNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_set not between", value1, value2, "integralSet");
            return (Criteria) this;
        }

        public Criteria andSigningConditionIsNull() {
            addCriterion("signing_condition is null");
            return (Criteria) this;
        }

        public Criteria andSigningConditionIsNotNull() {
            addCriterion("signing_condition is not null");
            return (Criteria) this;
        }

        public Criteria andSigningConditionEqualTo(String value) {
            addCriterion("signing_condition =", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionNotEqualTo(String value) {
            addCriterion("signing_condition <>", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionGreaterThan(String value) {
            addCriterion("signing_condition >", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionGreaterThanOrEqualTo(String value) {
            addCriterion("signing_condition >=", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionLessThan(String value) {
            addCriterion("signing_condition <", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionLessThanOrEqualTo(String value) {
            addCriterion("signing_condition <=", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionLike(String value) {
            addCriterion("signing_condition like", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionNotLike(String value) {
            addCriterion("signing_condition not like", value, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionIn(List<String> values) {
            addCriterion("signing_condition in", values, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionNotIn(List<String> values) {
            addCriterion("signing_condition not in", values, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionBetween(String value1, String value2) {
            addCriterion("signing_condition between", value1, value2, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andSigningConditionNotBetween(String value1, String value2) {
            addCriterion("signing_condition not between", value1, value2, "signingCondition");
            return (Criteria) this;
        }

        public Criteria andVenueIsNull() {
            addCriterion("venue is null");
            return (Criteria) this;
        }

        public Criteria andVenueIsNotNull() {
            addCriterion("venue is not null");
            return (Criteria) this;
        }

        public Criteria andVenueEqualTo(String value) {
            addCriterion("venue =", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueNotEqualTo(String value) {
            addCriterion("venue <>", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueGreaterThan(String value) {
            addCriterion("venue >", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueGreaterThanOrEqualTo(String value) {
            addCriterion("venue >=", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueLessThan(String value) {
            addCriterion("venue <", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueLessThanOrEqualTo(String value) {
            addCriterion("venue <=", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueLike(String value) {
            addCriterion("venue like", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueNotLike(String value) {
            addCriterion("venue not like", value, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueIn(List<String> values) {
            addCriterion("venue in", values, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueNotIn(List<String> values) {
            addCriterion("venue not in", values, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueBetween(String value1, String value2) {
            addCriterion("venue between", value1, value2, "venue");
            return (Criteria) this;
        }

        public Criteria andVenueNotBetween(String value1, String value2) {
            addCriterion("venue not between", value1, value2, "venue");
            return (Criteria) this;
        }

        public Criteria andTeamSizeIsNull() {
            addCriterion("team_size is null");
            return (Criteria) this;
        }

        public Criteria andTeamSizeIsNotNull() {
            addCriterion("team_size is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSizeEqualTo(Double value) {
            addCriterion("team_size =", value, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeNotEqualTo(Double value) {
            addCriterion("team_size <>", value, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeGreaterThan(Double value) {
            addCriterion("team_size >", value, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("team_size >=", value, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeLessThan(Double value) {
            addCriterion("team_size <", value, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeLessThanOrEqualTo(Double value) {
            addCriterion("team_size <=", value, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeIn(List<Double> values) {
            addCriterion("team_size in", values, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeNotIn(List<Double> values) {
            addCriterion("team_size not in", values, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeBetween(Double value1, Double value2) {
            addCriterion("team_size between", value1, value2, "teamSize");
            return (Criteria) this;
        }

        public Criteria andTeamSizeNotBetween(Double value1, Double value2) {
            addCriterion("team_size not between", value1, value2, "teamSize");
            return (Criteria) this;
        }

        public Criteria andEntryFeeIsNull() {
            addCriterion("entry_fee is null");
            return (Criteria) this;
        }

        public Criteria andEntryFeeIsNotNull() {
            addCriterion("entry_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEntryFeeEqualTo(Integer value) {
            addCriterion("entry_fee =", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeNotEqualTo(Integer value) {
            addCriterion("entry_fee <>", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeGreaterThan(Integer value) {
            addCriterion("entry_fee >", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("entry_fee >=", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeLessThan(Integer value) {
            addCriterion("entry_fee <", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeLessThanOrEqualTo(Integer value) {
            addCriterion("entry_fee <=", value, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeIn(List<Integer> values) {
            addCriterion("entry_fee in", values, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeNotIn(List<Integer> values) {
            addCriterion("entry_fee not in", values, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeBetween(Integer value1, Integer value2) {
            addCriterion("entry_fee between", value1, value2, "entryFee");
            return (Criteria) this;
        }

        public Criteria andEntryFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("entry_fee not between", value1, value2, "entryFee");
            return (Criteria) this;
        }

        public Criteria andJudgeIsNull() {
            addCriterion("judge is null");
            return (Criteria) this;
        }

        public Criteria andJudgeIsNotNull() {
            addCriterion("judge is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeEqualTo(String value) {
            addCriterion("judge =", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotEqualTo(String value) {
            addCriterion("judge <>", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeGreaterThan(String value) {
            addCriterion("judge >", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeGreaterThanOrEqualTo(String value) {
            addCriterion("judge >=", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLessThan(String value) {
            addCriterion("judge <", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLessThanOrEqualTo(String value) {
            addCriterion("judge <=", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeLike(String value) {
            addCriterion("judge like", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotLike(String value) {
            addCriterion("judge not like", value, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeIn(List<String> values) {
            addCriterion("judge in", values, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotIn(List<String> values) {
            addCriterion("judge not in", values, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeBetween(String value1, String value2) {
            addCriterion("judge between", value1, value2, "judge");
            return (Criteria) this;
        }

        public Criteria andJudgeNotBetween(String value1, String value2) {
            addCriterion("judge not between", value1, value2, "judge");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsIsNull() {
            addCriterion("referee_conditions is null");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsIsNotNull() {
            addCriterion("referee_conditions is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsEqualTo(String value) {
            addCriterion("referee_conditions =", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsNotEqualTo(String value) {
            addCriterion("referee_conditions <>", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsGreaterThan(String value) {
            addCriterion("referee_conditions >", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsGreaterThanOrEqualTo(String value) {
            addCriterion("referee_conditions >=", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsLessThan(String value) {
            addCriterion("referee_conditions <", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsLessThanOrEqualTo(String value) {
            addCriterion("referee_conditions <=", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsLike(String value) {
            addCriterion("referee_conditions like", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsNotLike(String value) {
            addCriterion("referee_conditions not like", value, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsIn(List<String> values) {
            addCriterion("referee_conditions in", values, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsNotIn(List<String> values) {
            addCriterion("referee_conditions not in", values, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsBetween(String value1, String value2) {
            addCriterion("referee_conditions between", value1, value2, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andRefereeConditionsNotBetween(String value1, String value2) {
            addCriterion("referee_conditions not between", value1, value2, "refereeConditions");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
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