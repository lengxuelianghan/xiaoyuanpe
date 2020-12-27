package com.xiaoyuanpe.pojo;

public class SportvenueItem {
    private Integer id;

    private String itemName;

    private String itemInfo;

    private Integer sportvenueId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo == null ? null : itemInfo.trim();
    }

    public Integer getSportvenueId() {
        return sportvenueId;
    }

    public void setSportvenueId(Integer sportvenueId) {
        this.sportvenueId = sportvenueId;
    }
}