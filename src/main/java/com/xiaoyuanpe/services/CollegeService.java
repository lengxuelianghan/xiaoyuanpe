package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.College;

import java.util.List;

public interface CollegeService {
    void addCollege(College college);

    List<College> findCollegeAll();

    College findCollegeById(Integer id);

    void ModifyCollege(College college);

    void DeleteCollege(Integer id);
    void DeleteCollegeList(List<Integer> ids);
}
