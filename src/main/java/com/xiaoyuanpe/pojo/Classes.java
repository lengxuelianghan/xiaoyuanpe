package com.xiaoyuanpe.pojo;

public class Classes {
    private Integer id;

    private String shchoolId;

    private Integer collegeId;

    private String className;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShchoolId() {
        return shchoolId;
    }

    public void setShchoolId(String shchoolId) {
        this.shchoolId = shchoolId == null ? null : shchoolId.trim();
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
}