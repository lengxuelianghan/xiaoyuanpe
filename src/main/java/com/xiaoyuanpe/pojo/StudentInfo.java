package com.xiaoyuanpe.pojo;

public class StudentInfo {
    private Integer id;
    private String name;
    private String number;
    private String password;
    private String sex;
    private Integer age;
    private String phone;
    private String school;
    private String college;
    private String classes;

    public StudentInfo(String name, String number, String password, String sex, Integer age, String phone) {
        this.name = name;
        this.number = number;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    public StudentInfo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
