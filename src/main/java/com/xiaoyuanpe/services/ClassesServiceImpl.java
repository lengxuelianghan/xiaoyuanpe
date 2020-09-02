package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.ClassesMapper;
import com.xiaoyuanpe.pojo.Classes;
import com.xiaoyuanpe.pojo.ClassesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
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
}
