package com.xiaoyuanpe.pojo;

import java.util.Date;

public class UserVenueEntry {
    private Integer id;

    private Integer venueId;

    private String venueName;

    private Integer sportvenueId;

    private String sportVenueName;

    private Integer spaceId;

    private String spaceName;

    private Date startTime;

    private Date endTime;

    private Integer userId;

    private String userName;

    private String others;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getSportvenueId() {
        return sportvenueId;
    }

    public void setSportvenueId(Integer sportvenueId) {
        this.sportvenueId = sportvenueId;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getSportVenueName() {
        return sportVenueName;
    }

    public void setSportVenueName(String sportVenueName) {
        this.sportVenueName = sportVenueName;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceNsme) {
        this.spaceName = spaceNsme;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
