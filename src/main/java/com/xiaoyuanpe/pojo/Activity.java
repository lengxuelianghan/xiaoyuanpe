package com.xiaoyuanpe.pojo;

import java.util.Date;

public class Activity {
    private Integer id;

    private String activityName;

    private String activityContent;

    private String imagePath;

    private Integer publisherId;

    private Date publishData;

    private Integer schoolId;

    private Integer collegeId;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private String college;

    private Date registrationClosingTime;

    private Date registrationStartTime;

    private String reviewerId;

    private String contact;

    private String contactPhone;

    private String wayRegistration;

    private String activityArea;

    private String eventLocation;

    private String activityClassification;

    private String participationFee;

    private String collegeList;

    private String classList;

    private Integer peopleNum;

    private String signout;

    private String fieldClock;

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
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Date getPublishData() {
        return publishData;
    }

    public void setPublishData(Date publishData) {
        this.publishData = publishData;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
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
        this.college = college == null ? null : college.trim();
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

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId == null ? null : reviewerId.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getWayRegistration() {
        return wayRegistration;
    }

    public void setWayRegistration(String wayRegistration) {
        this.wayRegistration = wayRegistration == null ? null : wayRegistration.trim();
    }

    public String getActivityArea() {
        return activityArea;
    }

    public void setActivityArea(String activityArea) {
        this.activityArea = activityArea == null ? null : activityArea.trim();
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation == null ? null : eventLocation.trim();
    }

    public String getActivityClassification() {
        return activityClassification;
    }

    public void setActivityClassification(String activityClassification) {
        this.activityClassification = activityClassification == null ? null : activityClassification.trim();
    }

    public String getParticipationFee() {
        return participationFee;
    }

    public void setParticipationFee(String participationFee) {
        this.participationFee = participationFee == null ? null : participationFee.trim();
    }

    public String getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(String collegeList) {
        this.collegeList = collegeList == null ? null : collegeList.trim();
    }

    public String getClassList() {
        return classList;
    }

    public void setClassList(String classList) {
        this.classList = classList == null ? null : classList.trim();
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getSignout() {
        return signout;
    }

    public void setSignout(String signout) {
        this.signout = signout == null ? null : signout.trim();
    }

    public String getFieldClock() {
        return fieldClock;
    }

    public void setFieldClock(String fieldClock) {
        this.fieldClock = fieldClock == null ? null : fieldClock.trim();
    }
}