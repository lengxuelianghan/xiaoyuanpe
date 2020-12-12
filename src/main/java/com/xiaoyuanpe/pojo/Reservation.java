package com.xiaoyuanpe.pojo;

import java.util.Date;

public class Reservation {
    private Integer id;

    private Integer sportvenueId;

    private Integer spaceId;

    private Date starttime;

    private Date endtime;

    private Integer status;

    private Integer hourIndex;

    private Integer dayIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHourIndex() {
        return hourIndex;
    }

    public void setHourIndex(Integer hourIndex) {
        this.hourIndex = hourIndex;
    }

    public Integer getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
    }
}