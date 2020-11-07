package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.UserRoleMapper;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.pojo.UserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void addUserRole(UserRole userRole) {
        this.userRoleMapper.insert(userRole);
    }

    @Override
    public List<UserRole> findUserRoleAll() {
        return this.userRoleMapper.selectByExample(new UserRoleExample());
    }

    @Override
    public UserRole findUserRoleById(Integer id) {
        return this.userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyUserRole(UserRole userRole) {
        this.userRoleMapper.updateByPrimaryKey(userRole);
    }

    @Override
    public void DeleteUserRole(Integer id) {
        this.userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteUserRoleList(List<Integer> ids) {
        for (Integer id: ids) {
            this.userRoleMapper.deleteByPrimaryKey(id);
        }
    }
}
