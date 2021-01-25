package com.xiaoyuanpe.pojo;

import java.util.Date;

public class Student {
    private Integer id;

    private Integer schoolId;

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

    private String schoolName;

    private String collegeName;

    private String classesName;

    private String classNumber;

    private String email;

    private String phone;

    private String identity;

    public Student(Integer id, Integer schoolId, Integer collegeId, Integer classesId, String studentName,
                   String studentNumber, Integer term, String sex, Date startYear, Date birthday, Integer gradeNumber,
                   String nationalCode, String idCard, String address, String schoolName, String collegeName,
                   String classesName, String classNumber, String phone, String email, String identity) {
        this.id = id;
        this.schoolId = schoolId;
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
        this.schoolName = schoolName;
        this.collegeName = collegeName;
        this.classesName = classesName;
        this.classNumber = classNumber;
        this.phone = phone;
        this.email = email;
        this.identity = identity;
    }
    public Student(){}

    public Student(Integer schoolId, Integer collegeId, Integer classesId, String studentName, String studentNumber,
                   Integer term, String sex, Date startYear, Date birthday, Integer gradeNumber, String nationalCode,
                   String idCard, String address, String schoolName, String collegeName, String classesName,
                   String classNumber,String phone, String email) {
        this.schoolId = schoolId;
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
        this.schoolName = schoolName;
        this.collegeName = collegeName;
        this.classesName = classesName;
        this.classNumber = classNumber;
        this.phone=phone;
        this.email = email;
    }

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", schoolId=" + schoolId +
                ", collegeId=" + collegeId +
                ", classesId=" + classesId +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", term=" + term +
                ", sex='" + sex + '\'' +
                ", startYear=" + startYear +
                ", birthday=" + birthday +
                ", gradeNumber=" + gradeNumber +
                ", nationalCode='" + nationalCode + '\'' +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", classesName='" + classesName + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}