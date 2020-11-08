package com.xiaoyuanpe.pojo;

import java.util.Date;

public class SinglePeopleInfo {
    private Date startTime;
    private Date endTime;
    private Integer timeLen;
    private float score;
    private String clasz;
    private String ActivityOrSportName;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getTimeLen() {
        return timeLen;
    }

    public void setTimeLen(Integer timeLen) {
        this.timeLen = timeLen;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getClasz() {
        return clasz;
    }

    public void setClasz(String clasz) {
        this.clasz = clasz;
    }

    public String getActivityOrSportName() {
        return ActivityOrSportName;
    }

    public void setActivityOrSportName(String activityOrSportName) {
        ActivityOrSportName = activityOrSportName;
    }
}
