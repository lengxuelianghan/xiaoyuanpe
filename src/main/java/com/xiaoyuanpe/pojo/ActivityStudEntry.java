package com.xiaoyuanpe.pojo;

import java.util.List;

public class ActivityStudEntry {

    private Integer id;

    private String activityId;

    private String studentId;

    private String characters;

    private String StudentNumber;

    private Integer SignStatus;

    private Integer studentIDNum;

    private Integer signId;

    private Integer status;

    private List<Projectsignin> projectsignins;

    public ActivityStudEntry() {
    }

    public ActivityStudEntry(Integer id, String activityId, String studentId, String characters, String studentNumber, Integer signStatus, Integer studentIDNum, Integer signId, Integer status, List<Projectsignin> projectsignins) {
        this.id = id;
        this.activityId = activityId;
        this.studentId = studentId;
        this.characters = characters;
        StudentNumber = studentNumber;
        SignStatus = signStatus;
        this.studentIDNum = studentIDNum;
        this.signId = signId;
        this.status = status;
        this.projectsignins = projectsignins;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }


    public String getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        StudentNumber = studentNumber;
    }

    public Integer getSignStatus() {
        return SignStatus;
    }

    public void setSignStatus(Integer signStatus) {
        SignStatus = signStatus;
    }

    public Integer getStudentIDNum() {
        return studentIDNum;
    }

    public void setStudentIDNum(Integer studentIDNum) {
        this.studentIDNum = studentIDNum;
    }

    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public List<Projectsignin> getProjectsignins() {
        return projectsignins;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setProjectsignins(List<Projectsignin> projectsignins) {
        this.projectsignins = projectsignins;
    }
}
