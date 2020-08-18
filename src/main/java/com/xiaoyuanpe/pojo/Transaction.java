package com.xiaoyuanpe.pojo;

import java.util.Date;

public class Transaction {
    private Integer id;

    private Integer shcoolId;

    private Integer userId;

    private Integer busnessId;

    private Date purchaseDate;

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