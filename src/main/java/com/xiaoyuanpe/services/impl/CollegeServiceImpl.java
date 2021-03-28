package com.xiaoyuanpe.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.CollegeMapper;
import com.xiaoyuanpe.pojo.College;
import com.xiaoyuanpe.pojo.CollegeExample;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Resource
    private CollegeMapper collegeMapper;

    private List<String> checkCollege(Integer id){
        List<College> colleges = this.collegeMapper.selectBySchool(id);
        List<String> collegeNames = new ArrayList<>();
        for (College college:colleges){
            collegeNames.add(college.getCollegeName());
        }
        return collegeNames;
    }

    @Override
    public String addCollege(College college) {
        List<String> stringList = checkCollege(college.getSchoolId());
        if (!stringList.contains(college.getCollegeName())) {
            this.collegeMapper.insert(college);
            return "插入成功";
        }
        else {
            return "学院名重复";
        }
    }

    @Override
    public void addBatch(List<College> college) {
        this.collegeMapper.insertBatch(college);
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
    public List<College> findCollegeBySchool(Integer schoolId) {
        return this.collegeMapper.selectBySchool(schoolId);
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
