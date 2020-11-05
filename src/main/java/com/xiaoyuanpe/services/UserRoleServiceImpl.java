package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Override
    public void addUserRole(UserRole userRole) {

    }

    @Override
    public List<UserRole> findUserRoleAll() {
        return null;
    }

    @Override
    public UserRole findUserRoleById(Integer id) {
        return null;
    }

    @Override
    public void ModifyUserRole(UserRole userRole) {

    }

    @Override
    public void DeleteUserRole(Integer id) {

    }

    @Override
    public void DeleteUserRoleList(List<Integer> ids) {

    }
}
