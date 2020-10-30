package com.xiaoyuanpe.pojo;

public class Classes {
    private Integer id;

    private Integer schoolId;

    private Integer collegeId;

    private String className;

    private Integer termYear;

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

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getTermYear() {
        return termYear;
    }

    public void setTermYear(Integer termYear) {
        this.termYear = termYear;
    }
}