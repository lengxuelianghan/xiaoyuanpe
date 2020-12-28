package com.xiaoyuanpe.pojo;

import java.util.Date;
import java.util.List;

public class ActivityEntry {

    private Integer id;

    private String activityName;

    private String activityContent;

    private String imagePath;

    private String publisherId;

    private Date publishData;

    private String schoolId;

    private Integer collegeId;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private String college;

    private Date registrationClosingTime;

    private Date registrationStartTime;

    private String contactPhone;

    private String activityArea;

    private String collegeList;

    private Integer peopleNum;

    private String costDescription;

    private String cost;
    private Integer activityClass;


    private List<Project> projectList;

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public Date getPublishData() {
        return publishData;
    }

    public void setPublishData(Date publishData) {
        this.publishData = publishData;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getRegistrationClosingTime() {
        return registrationClosingTime;
    }

    public void setRegistrationClosingTime(Date registrationClosingTime) {
        this.registrationClosingTime = registrationClosingTime;
    }

    public Date getRegistrationStartTime() {
        return registrationStartTime;
    }

    public void setRegistrationStartTime(Date registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }


    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }


    public String getActivityArea() {
        return activityArea;
    }

    public void setActivityArea(String activityArea) {
        this.activityArea = activityArea;
    }

    public String getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(String collegeList) {
        this.collegeList = collegeList;
    }


    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getCostDescription() {
        return costDescription;
    }

    public void setCostDescription(String costDescription) {
        this.costDescription = costDescription;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Integer activityClass) {
        this.activityClass = activityClass;
    }
}
