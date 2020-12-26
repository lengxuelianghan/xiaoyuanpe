package com.xiaoyuanpe.pojo;

import java.util.Date;

public class Venue {
    private Integer id;

    private String venueName;

    private String introduction;

    private String perPrice;

    private String phone;

    private Date closingDateStart;

    private Date closingDateEnd;

    private Date openingDateStart;

    private Date openingDateEnd;

    private String openingTime;

    private String venueAddr;

    private Integer schoolId;

    private String imgName;

    private String theBus;

    private String subway;

    private String imgs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName == null ? null : venueName.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(String perPrice) {
        this.perPrice = perPrice == null ? null : perPrice.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getClosingDateStart() {
        return closingDateStart;
    }

    public void setClosingDateStart(Date closingDateStart) {
        this.closingDateStart = closingDateStart;
    }

    public Date getClosingDateEnd() {
        return closingDateEnd;
    }

    public void setClosingDateEnd(Date closingDateEnd) {
        this.closingDateEnd = closingDateEnd;
    }

    public Date getOpeningDateStart() {
        return openingDateStart;
    }

    public void setOpeningDateStart(Date openingDateStart) {
        this.openingDateStart = openingDateStart;
    }

    public Date getOpeningDateEnd() {
        return openingDateEnd;
    }

    public void setOpeningDateEnd(Date openingDateEnd) {
        this.openingDateEnd = openingDateEnd;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime == null ? null : openingTime.trim();
    }

    public String getVenueAddr() {
        return venueAddr;
    }

    public void setVenueAddr(String venueAddr) {
        this.venueAddr = venueAddr == null ? null : venueAddr.trim();
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public String getTheBus() {
        return theBus;
    }

    public void setTheBus(String theBus) {
        this.theBus = theBus == null ? null : theBus.trim();
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway == null ? null : subway.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }
}