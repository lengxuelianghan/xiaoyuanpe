package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SemesterMapper;
import com.xiaoyuanpe.pojo.Semester;
import com.xiaoyuanpe.pojo.SemesterExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterServiceImpl implements SemesterService {
    @Autowired
    private SemesterMapper semesterMapper;

    @Override
    public void addSemester(Semester semester) {
        this.semesterMapper.insert(semester);
    }

    @Override
    public List<Semester> findSemesterAll() {
        SemesterExample semesterExample = new SemesterExample();
        return this.semesterMapper.selectByExample(semesterExample);
    }

    @Override
    public Semester findSemesterById(Integer id) {
        return this.semesterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifySemester(Semester semester) {
        this.semesterMapper.updateByPrimaryKey(semester);
    }

    @Override
    public void DeleteSemester(Integer id) {
        this.semesterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Semester findSemesterByIds(Integer schoolId, Integer collegeId, Integer classId, Integer studentId, Integer term) {
        return this.semesterMapper.selectByPrimaryKeys(schoolId,collegeId,classId,studentId,term);
    }

    @Override
    public List<Semester> findSemesterByStudent(Integer schoolId, Integer collegeId, Integer classId, Integer studentId) {
        return this.semesterMapper.selectByPrimaryStudent(schoolId,collegeId,classId,studentId);
    }

    @Override
    public List<Semester> findSemesterByClasses(Integer schoolId, Integer collegeId, Integer classId, Integer term) {
        return this.semesterMapper.selectByPrimaryClasses(schoolId,collegeId,classId,term);
    }

    @Override
    public List<Semester> findSemesterByCollege(Integer schoolId, Integer collegeId, Integer term) {
        return this.semesterMapper.selectByPrimaryCollege(schoolId,collegeId,term);
    }

    @Override
    public List<Semester> selectByPrimarySchool(Integer schoolId, Integer term) {
        return this.semesterMapper.selectByPrimarySchool(schoolId,term);
    }

    @Override
    public void addBatch(List<Semester> semesters) {
        this.semesterMapper.insertBatch(semesters);
    }
}
