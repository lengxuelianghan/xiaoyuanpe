package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.StudentExample;
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
    public Student findStudentByNumber(String snumber) {
        return this.studentMapper.selectByPrimaryNumber(snumber);
    }
}
