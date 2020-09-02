package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.CollegeMapper;
import com.xiaoyuanpe.pojo.College;
import com.xiaoyuanpe.pojo.CollegeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public void addCollege(College college) {
        this.collegeMapper.insert(college);
    }

    @Override
    public List<College> findCollegeAll() {
        CollegeExample collegeExample = new CollegeExample();
        return this.collegeMapper.selectByExample(collegeExample);
    }

    @Override
    public College findCollegeById(Integer id) {
        return this.collegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyCollege(College college) {
        this.collegeMapper.updateByPrimaryKey(college);
    }

    @Override
    public void DeleteCollege(Integer id) {
        this.collegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteCollegeList(List<Integer> ids) {
        this.collegeMapper.deleteByPrimaryKeys(ids);
    }
}
