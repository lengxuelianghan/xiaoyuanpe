package com.xiaoyuanpe.pojo;

import java.math.BigDecimal;

public class Business {
    private Integer id;

    private String bueinesName;

    private Integer userlId;

    private BigDecimal bueinesPrice;

    private String bueinesInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBueinesName() {
        return bueinesName;
    }

    public void setBueinesName(String bueinesName) {
        this.bueinesName = bueinesName == null ? null : bueinesName.trim();
    }

    public Integer getUserlId() {
        return userlId;
    }

    public void setUserlId(Integer userlId) {
        this.userlId = userlId;
    }

    public BigDecimal getBueinesPrice() {
        return bueinesPrice;
    }

    public void setBueinesPrice(BigDecimal bueinesPrice) {
        this.bueinesPrice = bueinesPrice;
    }

    public String getBueinesInfo() {
        return bueinesInfo;
    }

    public void setBueinesInfo(String bueinesInfo) {
        this.bueinesInfo = bueinesInfo == null ? null : bueinesInfo.trim();
    }
}