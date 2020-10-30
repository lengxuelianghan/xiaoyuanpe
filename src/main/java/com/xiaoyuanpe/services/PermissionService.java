package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Permissions;

import java.util.List;

public interface PermissionService {
    void addPermissions(Permissions permissions);

    List<Permissions> findPermissionsAll();

    Permissions findPermissionsById(Integer id);

    void ModifyPermissions(Permissions permissions);

    void DeletePermissions(Integer id);
}
