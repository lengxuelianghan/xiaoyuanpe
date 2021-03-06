package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(List<Integer> ids);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    Student selectLast();

    Student selectByPrimaryNumber(String snumber);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectBySchool(@Param("id")Integer id, @Param("columnName")String columnName, @Param("searchContent")String searchContent);

    List<Student> selectBySchoolInt(@Param("id")Integer id, @Param("columnName")String columnName, @Param("searchContent")Integer searchContent);

    List<Student> selectByCollegeWithSomething(@Param("id")Integer id, @Param("columnName")String columnName, @Param("searchContent")String searchContent);

    List<Student> selectByClassesWithSomething(@Param("id")Integer id, @Param("columnName")String columnName, @Param("searchContent")String searchContent);

    List<Student> selectByCollege(Integer id);

    List<Student> selectByClass(Integer id);

    List<Student> selectBySchoolPure(Integer id);

    int insertBatch(List<Student> students);

    Student selectByNumberAndSchool(@Param("snumber") String snumber, @Param("id") Integer id);

    void updateBatch(List<Student> students);
}