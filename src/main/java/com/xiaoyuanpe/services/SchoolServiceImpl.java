package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SchoolMapper;
import com.xiaoyuanpe.pojo.School;
import com.xiaoyuanpe.pojo.SchoolExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;
    @Override
    public void addSchool(School school) {
        this.schoolMapper.insert(school);
    }

    @Override
    public List<School> findSchoolAll() {
        SchoolExample example = new SchoolExample();
        return this.schoolMapper.selectByExample(example);
    }

    @Override
    public School findSchoolById(Integer id) {
        return this.schoolMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifySchool(School school) {
        this.schoolMapper.updateByPrimaryKey(school);
    }

    @Override
    public void DeleteSchool(Integer id) {
        this.schoolMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteSchoolList(List<Integer> ids) {
        this.schoolMapper.deleteByPrimaryKeys(ids);
    }
}
