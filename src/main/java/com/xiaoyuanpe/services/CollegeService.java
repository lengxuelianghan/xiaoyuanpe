package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.College;
import com.xiaoyuanpe.pojo.Page;

import java.util.List;

public interface CollegeService {
    void addCollege(College college);

    PageInfo<College> findCollegeAll(Page page, Integer id);

    List<College> findCollegeAll();

    College findCollegeById(Integer id);

    void ModifyCollege(College college);

    void DeleteCollege(Integer id);

    void DeleteCollegeList(List<Integer> ids);
}
