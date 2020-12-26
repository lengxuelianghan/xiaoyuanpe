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

    private String imgName;

    private String floor;

    private String light;

    private String restArea;

    private String equipmentRental;

    private String equipmentMaintenance;

    private String moreServices;

    private String bathingFacilities;

    private String venueSales;

    private String invoice;

    private String parking;

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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light == null ? null : light.trim();
    }

    public String getRestArea() {
        return restArea;
    }

    public void setRestArea(String restArea) {
        this.restArea = restArea == null ? null : restArea.trim();
    }

    public String getEquipmentRental() {
        return equipmentRental;
    }

    public void setEquipmentRental(String equipmentRental) {
        this.equipmentRental = equipmentRental == null ? null : equipmentRental.trim();
    }

    public String getEquipmentMaintenance() {
        return equipmentMaintenance;
    }

    public void setEquipmentMaintenance(String equipmentMaintenance) {
        this.equipmentMaintenance = equipmentMaintenance == null ? null : equipmentMaintenance.trim();
    }

    public String getMoreServices() {
        return moreServices;
    }

    public void setMoreServices(String moreServices) {
        this.moreServices = moreServices == null ? null : moreServices.trim();
    }

    public String getBathingFacilities() {
        return bathingFacilities;
    }

    public void setBathingFacilities(String bathingFacilities) {
        this.bathingFacilities = bathingFacilities == null ? null : bathingFacilities.trim();
    }

    public String getVenueSales() {
        return venueSales;
    }

    public void setVenueSales(String venueSales) {
        this.venueSales = venueSales == null ? null : venueSales.trim();
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking == null ? null : parking.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }
}