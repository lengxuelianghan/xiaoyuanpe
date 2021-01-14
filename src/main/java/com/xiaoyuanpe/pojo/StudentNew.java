package com.xiaoyuanpe.pojo;

import java.util.Date;

public class StudentNew {
    private Integer id;

    private Integer shcoolId;

    private Integer collegeId;

    private Integer classesId;

    private String studentName;

    private String studentNumber;

    private Integer term;

    private String sex;

    private Date startYear;

    private Date birthday;

    private Integer gradeNumber;

    private String nationalCode;

    private String idCard;

    private String  address;

    private Integer school;

    private Integer college;

    private Integer classes;

    public StudentNew(Integer id, Integer shcoolId, Integer collegeId, Integer classesId, String studentName,
                   String studentNumber, Integer term, String sex, Date startYear, Date birthday, Integer gradeNumber,
                   String nationalCode, String idCard, String address, Integer school, Integer college,
                   Integer classes) {
        this.id = id;
        this.shcoolId = shcoolId;
        this.collegeId = collegeId;
        this.classesId = classesId;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.term = term;
        this.sex = sex;
        this.startYear = startYear;
        this.birthday = birthday;
        this.gradeNumber = gradeNumber;
        this.nationalCode = nationalCode;
        this.idCard = idCard;
        this.address = address;
        this.school = school;
        this.college = college;
        this.classes = classes;
    }
    public StudentNew(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShcoolId() {
        return shcoolId;
    }

    public void setShcoolId(Integer shcoolId) {
        this.shcoolId = shcoolId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getStartYear() {
        return startYear;
    }

    public void setStartYear(Date startYear) {
        this.startYear = startYear;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(Integer gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSchoolName() {
        return school;
    }

    public void setSchoolName(Integer schoolName) {
        this.school = schoolName;
    }

    public Integer getCollegeName() {
        return college;
    }

    public void setCollegeName(Integer collegeName) {
        this.college = collegeName;
    }

    public Integer getClassesName() {
        return classes;
    }

    public void setClassesName(Integer classesName) {
        this.classes = classesName;
    }
}
