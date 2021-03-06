package com.xiaoyuanpe.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public void addStudent(Student student) {
            this.studentMapper.insert(student);
    }

    @Override
    public List<Student> findStudentAll() {
        StudentExample studentExample = new StudentExample();
        return this.studentMapper.selectByExample(studentExample);
    }

    @Override
    public Student findStudentById(Integer id) {
        return this.studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyStudent(Student student) {
        this.studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public void DeleteStudent(Integer id) {
        this.studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteStudentList(List<Integer> ids) {
        this.studentMapper.deleteByPrimaryKeys(ids);
    }

    @Override
    public Student findStudentByNumber(String snumber) {
        return this.studentMapper.selectByPrimaryNumber(snumber);
    }

    @Override
    public Student findStudentLast() {
        return this.studentMapper.selectLast();
    }

    @Override
    public PageInfo<Student> findStudentByClass(Integer id, Page page) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Student> studentInfoPage = new PageInfo<>(this.studentMapper.selectByClass(id));
        return studentInfoPage;
    }

    @Override
    public PageInfo<Student> findStudentByCollege(Integer id, Page page) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Student> studentInfoPage = new PageInfo<>(this.studentMapper.selectByCollege(id));
        return studentInfoPage;
    }

    @Override
    public PageInfo<Student> findStudentBySchoolPure(Integer id, Page page) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Student> studentInfoPage = new PageInfo<>(this.studentMapper.selectBySchoolPure(id));
        return studentInfoPage;
    }

    @Override
    public PageInfo<Student> findStudentBySchool(Integer id, Page page,String columnName, String searchContent) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Student> studentInfoPage = null;
        if (columnName.equals("classes_name")){
            columnName = "class_name";
            studentInfoPage = new PageInfo<>(this.studentMapper.selectByClassesWithSomething(id,columnName,searchContent));
        }
        else if (columnName.equals("college_name")){
            studentInfoPage = new PageInfo<>(this.studentMapper.selectByCollegeWithSomething(id,columnName,searchContent));
        }
        else
            studentInfoPage = new PageInfo<>(this.studentMapper.selectBySchool(id,columnName,searchContent));
        return studentInfoPage;
    }

    @Override
    public PageInfo<Student> findStudentBySchoolInt(Integer id, Page page, String columnName, Integer searchContent) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Student> studentInfoPage = new PageInfo<>(this.studentMapper.selectBySchoolInt(id,columnName,searchContent));
        return studentInfoPage;
    }

    @Override
    public void addBatch(List<Student> list) {
        this.studentMapper.insertBatch(list);
    }

    @Override
    public Student findStudentByNumberAndSchool(String snumber, int id) {
        return this.studentMapper.selectByNumberAndSchool(snumber, id);
    }

    @Override
    public void ModifyBatch(List<Student> students) {
        this.studentMapper.updateBatch(students);
    }
}
