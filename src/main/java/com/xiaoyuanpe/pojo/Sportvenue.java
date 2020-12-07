package com.xiaoyuanpe.pojo;

import java.util.Date;

public class Sportvenue {
    private Integer id;

    private String sportName;

    private Double siteSize;

    private Integer numberVenues;

    private Double area;

    private Date constructionTime;

    private String other;

    private Integer venueId;

    private String imgs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName == null ? null : sportName.trim();
    }

    public Double getSiteSize() {
        return siteSize;
    }

    public void setSiteSize(Double siteSize) {
        this.siteSize = siteSize;
    }

    public Integer getNumberVenues() {
        return numberVenues;
    }

    public void setNumberVenues(Integer numberVenues) {
        this.numberVenues = numberVenues;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Date getConstructionTime() {
        return constructionTime;
    }

    public void setConstructionTime(Date constructionTime) {
        this.constructionTime = constructionTime;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }
}