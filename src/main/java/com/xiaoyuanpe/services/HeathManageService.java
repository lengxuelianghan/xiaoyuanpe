package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Healthmanagement;

import java.util.List;

public interface HeathManageService {
    void addHealthmanagement(Healthmanagement healthmanagement);

    List<Healthmanagement> findHealthmanagementAll();

    Healthmanagement findCollegeHealthmanagementById(Integer id);

    void ModifyHealthmanagement(Healthmanagement healthmanagement);

    void DeleteHealthmanagement(Integer id);

    Healthmanagement selectByPrimaryByStudentId(Integer id);
}
