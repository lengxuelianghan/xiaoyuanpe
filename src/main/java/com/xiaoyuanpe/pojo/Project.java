package com.xiaoyuanpe.pojo;

public class Project {
    private Integer id;

    private String projectName;

    private Boolean team;

    private Integer maximum;

    private String integralSet;

    private String signingCondition;

    private String venue;

    private Integer entryFee;

    private Byte judge;

    private String refereeConditions;

    private Integer activityId;

    private Integer teamPeople;

    private Integer minmum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Boolean getTeam() {
        return team;
    }

    public void setTeam(Boolean team) {
        this.team = team;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public String getIntegralSet() {
        return integralSet;
    }

    public void setIntegralSet(String integralSet) {
        this.integralSet = integralSet == null ? null : integralSet.trim();
    }

    public String getSigningCondition() {
        return signingCondition;
    }

    public void setSigningCondition(String signingCondition) {
        this.signingCondition = signingCondition == null ? null : signingCondition.trim();
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue == null ? null : venue.trim();
    }

    public Integer getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(Integer entryFee) {
        this.entryFee = entryFee;
    }

    public Byte getJudge() {
        return judge;
    }

    public void setJudge(Byte judge) {
        this.judge = judge;
    }

    public String getRefereeConditions() {
        return refereeConditions;
    }

    public void setRefereeConditions(String refereeConditions) {
        this.refereeConditions = refereeConditions == null ? null : refereeConditions.trim();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getTeamPeople() {
        return teamPeople;
    }

    public void setTeamPeople(Integer teamPeople) {
        this.teamPeople = teamPeople;
    }

    public Integer getMinmum() {
        return minmum;
    }

    public void setMinmum(Integer minmum) {
        this.minmum = minmum;
    }
}