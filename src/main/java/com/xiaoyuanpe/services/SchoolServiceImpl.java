package com.xiaoyuanpe.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.SchoolMapper;
import com.xiaoyuanpe.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Resource
    private SchoolMapper schoolMapper;
    @Resource
    private UserService userService;
    @Resource
    private StudentService studentService;
    @Override
    public void addSchool(School school) {
        this.schoolMapper.insert(school);
    }

    @Override
    public PageInfo<School> findSchoolAll(Page page) {
        SchoolExample example = new SchoolExample();
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<School> schoolPageInfo = new PageInfo<>(this.schoolMapper.selectByExample(example));
        return schoolPageInfo;
    }

    @Override
    public List<School> findSchoolAll() {
        return this.schoolMapper.selectByExample(new SchoolExample());
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

    @Override
    public List<School> findSchoolBySchoolId() {
        return null;
    }

    @Override
    public void ModifyValidPeriod(School school) {
        this.schoolMapper.updateValidPeriod(school);
    }

    @Override
    public PageInfo<School> selectBySchoolName(Page page, String schoolName, String searchContent) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<School> schoolPageInfo = new PageInfo<>(this.schoolMapper.selectBySchoolName(schoolName, searchContent));
        return schoolPageInfo;
    }
}
