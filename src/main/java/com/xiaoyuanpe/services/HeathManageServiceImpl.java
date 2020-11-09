package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.HealthmanagementMapper;
import com.xiaoyuanpe.pojo.Healthmanagement;
import com.xiaoyuanpe.pojo.HealthmanagementExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeathManageServiceImpl implements HeathManageService {
    @Autowired
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
}
