package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Semester;

import java.util.List;

public interface SemesterService {
    void addSemester(Semester semester);

    List<Semester> findSemesterAll();

    Semester findSemesterById(Integer id);

    void ModifySemester(Semester semester);

    void DeleteSemester(Integer id);

    Semester findSemesterByIds(Integer shcoolId, Integer collegeId,Integer classId,Integer studentId,Integer term);
}
