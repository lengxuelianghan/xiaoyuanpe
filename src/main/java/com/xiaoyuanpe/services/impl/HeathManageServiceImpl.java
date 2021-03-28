package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.HealthmanagementMapper;
import com.xiaoyuanpe.pojo.Healthmanagement;
import com.xiaoyuanpe.pojo.HealthmanagementExample;
import com.xiaoyuanpe.services.HeathManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HeathManageServiceImpl implements HeathManageService {
    @Resource
    private HealthmanagementMapper healthmanagementMapper;
    @Override
    public void addHealthmanagement(Healthmanagement healthmanagement) {
        this.healthmanagementMapper.insert(healthmanagement);
    }

    @Override
    public List<Healthmanagement> findHealthmanagementAll() {
        return this.healthmanagementMapper.selectByExample(new HealthmanagementExample());
    }

    @Override
    public Healthmanagement findCollegeHealthmanagementById(Integer id) {
        return this.healthmanagementMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyHealthmanagement(Healthmanagement healthmanagement) {
        this.healthmanagementMapper.updateByPrimaryKey(healthmanagement);
    }

    @Override
    public void DeleteHealthmanagement(Integer id) {
        this.healthmanagementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Healthmanagement selectByPrimaryByStudentId(Integer id) {
        return this.healthmanagementMapper.selectByPrimaryByStudentId(id);
    }
}
