package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.RoleMapper;
import com.xiaoyuanpe.pojo.Role;
import com.xiaoyuanpe.pojo.RoleExample;
import com.xiaoyuanpe.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("role")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public void addRole(Role role) {
        this.roleMapper.insert(role);
    }

    @Override
    public List<Role> findRoleAll() {
        RoleExample roleExample = new RoleExample();
        return this.roleMapper.selectByExample(roleExample);
    }

    @Override
    public Role findRoleById(Integer id) {
        return this.roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyRole(Role role) {
        this.roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void DeleteRole(Integer id) {

    }
}
