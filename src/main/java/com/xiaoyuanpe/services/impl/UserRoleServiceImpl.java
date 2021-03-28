package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.UserRoleMapper;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.pojo.UserRoleExample;
import com.xiaoyuanpe.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
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
        for (Integer id : ids) {
            this.userRoleMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<UserRole> findUserRoleByUserId(Integer id) {
        return this.userRoleMapper.selectByUserId(id);
    }
}
