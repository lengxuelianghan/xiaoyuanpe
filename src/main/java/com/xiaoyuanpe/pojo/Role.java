package com.xiaoyuanpe.pojo;

import java.util.List;

public class Role {
    private Integer id;

    private String roleName;

    private Integer roleType;

    private List<Permissions> perms;

    public List<Permissions> getPerms() {
        return perms;
    }

    public void setPerms(List<Permissions> perms) {
        this.perms = perms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
}