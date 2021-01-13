package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.pojo.School;

import java.util.List;

public interface SchoolService {
    void addSchool(School school);

    PageInfo<School> findSchoolAll(Page page);

    School findSchoolById(Integer id);

    void ModifySchool(School school);

    void DeleteSchool(Integer id);

    void DeleteSchoolList(List<Integer> ids);

    List<School> findSchoolBySchoolId();
}
