package com.xiaoyuanpe.pojo;

public class College {
    private Integer id;

    private Integer schoolId;

    private String collegeName;

    private Integer score;

    private String collegeInfo;

    private String collegeNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCollegeInfo() {
        return collegeInfo;
    }

    public void setCollegeInfo(String collegeInfo) {
        this.collegeInfo = collegeInfo == null ? null : collegeInfo.trim();
    }

    public String getCollegeNumber() {
        return collegeNumber;
    }

    public void setCollegeNumber(String collegeNumber) {
        this.collegeNumber = collegeNumber;
    }
}