package com.xiaoyuanpe.pojo;

import java.util.Date;

public class Transaction {
    private Integer id;

    private Integer schoolId;

    private Integer userId;

    private Integer busnessId;

    private Date purchaseDate;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBusnessId() {
        return busnessId;
    }

    public void setBusnessId(Integer busnessId) {
        this.busnessId = busnessId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}