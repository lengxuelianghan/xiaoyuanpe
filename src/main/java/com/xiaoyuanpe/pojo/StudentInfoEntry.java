package com.xiaoyuanpe.pojo;

import java.util.Date;

public class StudentInfoEntry {
    private Integer id;
    private String studentName;
    private String studentNumber;
    private Integer flag;
    private String classz;
    private String college;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getClassz() {
        return classz;
    }

    public void setClassz(String classz) {
        this.classz = classz;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
