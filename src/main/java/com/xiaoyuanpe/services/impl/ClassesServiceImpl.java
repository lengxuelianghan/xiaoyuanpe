package com.xiaoyuanpe.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.ClassesMapper;
import com.xiaoyuanpe.pojo.Classes;
import com.xiaoyuanpe.pojo.ClassesExample;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.services.ClassesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private ClassesMapper classesMapper;

    @Override
    public void addClasses(Classes classes) {
        this.classesMapper.insert(classes);
    }

    @Override
    public List<Classes> findClassesAll() {
        ClassesExample classesExample = new ClassesExample();
        return this.classesMapper.selectByExample(classesExample);
    }

    @Override
    public List<Classes> findClassesBySchool(Integer id) {
        return this.classesMapper.selectBySchool(id);
    }

    @Override
    public Classes findClassesById(Integer id) {
        return this.classesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyClasses(Classes classes) {
        this.classesMapper.updateByPrimaryKey(classes);
    }

    @Override
    public void DeleteClasses(Integer id) {
        this.classesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteClassesList(List<Integer> ids) {
        this.classesMapper.deleteByPrimaryKeys(ids);
    }

    @Override
    public PageInfo<Classes> selectBySchool(Page page, Integer id) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Classes> classesPageInfo = new PageInfo<>(this.classesMapper.selectBySchool(id));
        return classesPageInfo;
    }

    @Override
    public PageInfo<Classes> selectByCollege(Page page, Integer id) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Classes> classesPageInfo = new PageInfo<>(this.classesMapper.selectByCollege(id));
        return classesPageInfo;
    }

    @Override
    public List<Classes> findClassesByCollege(Integer id) {
        return this.classesMapper.findClassesByCollege(id);
    }

    @Override
    public void addBatch(List<Classes> classes) {
        this.classesMapper.insertBatch(classes);
    }
}
