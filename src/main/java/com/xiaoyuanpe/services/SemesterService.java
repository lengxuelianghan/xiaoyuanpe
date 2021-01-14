package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Semester;

import java.util.List;

public interface SemesterService {
    void addSemester(Semester semester);

    List<Semester> findSemesterAll();

    Semester findSemesterById(Integer id);

    void ModifySemester(Semester semester);

    void DeleteSemester(Integer id);

    Semester findSemesterByIds(Integer schoolId, Integer collegeId,Integer classId,Integer studentId,Integer term);

    List<Semester> findSemesterByStudent(Integer schoolId, Integer collegeId,Integer classId,Integer studentId);

    List<Semester> findSemesterByClasses(Integer schoolId, Integer collegeId,Integer classId,Integer term);

    List<Semester> findSemesterByCollege(Integer schoolId, Integer collegeId, Integer term);

    List<Semester> selectByPrimarySchool(Integer schoolId, Integer term);

    void addBatch(List<Semester> semesters);

}
