package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.Classes;
import com.xiaoyuanpe.pojo.Page;

import java.util.List;

public interface ClassesService {
    void addClasses(Classes classes);

    List<Classes> findClassesAll();

    Classes findClassesById(Integer id);

    void ModifyClasses(Classes classes);

    void DeleteClasses(Integer id);

    void DeleteClassesList(List<Integer> ids);

    PageInfo<Classes> selectBySchool(Page page, Integer id);

    PageInfo<Classes> selectByCollege(Page page, Integer id);

    List<Classes> findClassesByCollege(Integer id);

    void addBatch(List<Classes> classes);
}
