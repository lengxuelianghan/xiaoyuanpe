package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.PermissionsMapper;
import com.xiaoyuanpe.pojo.Permissions;
import com.xiaoyuanpe.pojo.PermissionsExample;
import com.xiaoyuanpe.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PermissionsServiceImpl implements PermissionService {
    @Resource
    private PermissionsMapper permissionsMapper;

    @Override
    public void addPermissions(Permissions permissions) {
        this.permissionsMapper.insert(permissions);
    }

    @Override
    public List<Permissions> findPermissionsAll() {
        return this.permissionsMapper.selectByExample(new PermissionsExample());
    }

    @Override
    public Permissions findPermissionsById(Integer id) {
        return this.permissionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyPermissions(Permissions permissions) {
        this.permissionsMapper.updateByPrimaryKey(permissions);
    }

    @Override
    public void DeletePermissions(Integer id) {
        this.permissionsMapper.deleteByPrimaryKey(id);
    }
}
