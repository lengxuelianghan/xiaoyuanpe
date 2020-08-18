package com.xiaoyuanpe.pojo;

public class School {
    private Integer id;

    private String schoolName;

    private String schoolAddress;

    private String phone;

    private String schoolZipCode;

    private String schoolIntroduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress == null ? null : schoolAddress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSchoolZipCode() {
        return schoolZipCode;
    }

    public void setSchoolZipCode(String schoolZipCode) {
        this.schoolZipCode = schoolZipCode == null ? null : schoolZipCode.trim();
    }

    public String getSchoolIntroduction() {
        return schoolIntroduction;
    }

    public void setSchoolIntroduction(String schoolIntroduction) {
        this.schoolIntroduction = schoolIntroduction == null ? null : schoolIntroduction.trim();
    }
}