package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> findStudentAll();

    Student findStudentById(Integer id);

    void ModifyStudent(Student student);

    void DeleteStudent(Integer id);

    Student findStudentByNumber(String snumber);

    Student findStudentLast();
}
