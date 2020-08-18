package com.xiaoyuanpe.pojo;

public class Identities {
    private Integer id;

    private String identityName;

    private Integer identityReward;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName == null ? null : identityName.trim();
    }

    public Integer getIdentityReward() {
        return identityReward;
    }

    public void setIdentityReward(Integer identityReward) {
        this.identityReward = identityReward;
    }
}