package com.xiaoyuanpe.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.CollegeMapper;
import com.xiaoyuanpe.pojo.College;
import com.xiaoyuanpe.pojo.CollegeExample;
import com.xiaoyuanpe.pojo.Page;
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
    public PageInfo<College> findCollegeAll(Page page, Integer id) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<College> collegePageInfo = new PageInfo<>(this.collegeMapper.selectBySchool(id));
        return collegePageInfo;
    }

    @Override
    public List<College> findCollegeAll() {
        return this.collegeMapper.selectByExample(new CollegeExample());
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
