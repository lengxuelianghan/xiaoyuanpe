package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
    void addUserRole(UserRole userRole);

    List<UserRole> findUserRoleAll();

    UserRole findUserRoleById(Integer id);

    void ModifyUserRole(UserRole userRole);

    void DeleteUserRole(Integer id);

    void DeleteUserRoleList(List<Integer> ids);
}
