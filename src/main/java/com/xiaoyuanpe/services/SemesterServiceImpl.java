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
    public Semester findSemesterByIds(Integer shcoolId, Integer collegeId, Integer classId, Integer studentId, Integer term) {
        return this.semesterMapper.selectByPrimaryKeys(shcoolId,collegeId,classId,studentId,term);
    }
}
