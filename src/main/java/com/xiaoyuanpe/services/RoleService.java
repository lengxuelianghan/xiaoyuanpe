package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    List<Role> findRoleAll();

    Role findRoleById(Integer id);

    void ModifyRole(Role role);

    void DeleteRole(Integer id);
}
