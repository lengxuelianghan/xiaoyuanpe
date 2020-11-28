package com.xiaoyuanpe.pojo;

import java.util.Date;
import java.util.List;

public class Signin {
    private Integer id;

    private Integer studentId;

    private Date signTime;

    private Integer flag;

    private Date signoutTime;

    private Integer activityId;

    private Integer sportId;

    private List<ProjectSignInEntry> projectSignInEntryList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getSignoutTime() {
        return signoutTime;
    }

    public void setSignoutTime(Date signoutTime) {
        this.signoutTime = signoutTime;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public List<ProjectSignInEntry> getProjectSignInEntryList() {
        return projectSignInEntryList;
    }

    public void setProjectSignInEntryList(List<ProjectSignInEntry> projectSignInEntryList) {
        this.projectSignInEntryList = projectSignInEntryList;
    }
}