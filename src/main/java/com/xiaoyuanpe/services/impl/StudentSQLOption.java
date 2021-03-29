package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.services.BasicSQLOption;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:
 * @Date: Created in 23:01 2021/3/28
 * @Description:
 * @Modified By:
 */

@Service
public class StudentSQLOption implements BasicSQLOption<Integer, Student> {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void createRecord(Student data) {
        studentMapper.insert(data);
    }

    @Override
    public Void updateRecord(Student data) {
        return null;
    }

    @Override
    public Void deleteRecord(List<Integer> ids) {
        return null;
    }

    @Override
    public Student findByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
