package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Student;

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
}
