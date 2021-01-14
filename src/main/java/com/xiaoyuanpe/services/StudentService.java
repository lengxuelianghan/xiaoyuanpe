package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.StudentInfo;
import com.xiaoyuanpe.pojo.StudentNew;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> findStudentAll();

    Student findStudentById(Integer id);

    void ModifyStudent(Student student);

    void DeleteStudent(Integer id);

    void DeleteStudentList(List<Integer> ids);

    Student findStudentByNumber(String snumber);

    Student findStudentLast();

    PageInfo<Student> findStudentByClass(Integer id, Page page);

    PageInfo<Student> findStudentByCollege(Integer id, Page page);

    PageInfo<Student> findStudentBySchool(Integer id, Page page);
}
