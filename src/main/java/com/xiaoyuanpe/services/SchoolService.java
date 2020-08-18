package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.School;

import java.util.List;

public interface SchoolService {
    void addSchool(School school);

    List<School> findSchoolAll();

    School findSchoolById(Integer id);

    void ModifySchool(School school);

    void DeleteSchool(Integer id);
}
