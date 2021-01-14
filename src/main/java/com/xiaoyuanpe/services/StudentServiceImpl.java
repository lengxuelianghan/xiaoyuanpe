package com.xiaoyuanpe.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
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
    public PageInfo<Student> findStudentBySchool(Integer id, Page page) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<Student> studentInfoPage = new PageInfo<>(this.studentMapper.selectBySchool(id));
        return studentInfoPage;
    }
}
