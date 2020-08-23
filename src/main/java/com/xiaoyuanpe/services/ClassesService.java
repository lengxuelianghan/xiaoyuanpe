package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Classes;

import java.util.List;

public interface ClassesService {
    void addClasses(Classes classes);

    List<Classes> findClassesAll();

    Classes findClassesById(Integer id);

    void ModifyClasses(Classes classes);

    void DeleteClasses(Integer id);
}
