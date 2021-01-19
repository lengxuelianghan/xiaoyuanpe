package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.School;
import com.xiaoyuanpe.pojo.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper {
    long countByExample(SchoolExample example);

    int deleteByExample(SchoolExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(List<Integer> ids);

    int insert(School record);

    int insertSelective(School record);

    List<School> selectByExampleWithBLOBs(SchoolExample example);

    List<School> selectByExample(SchoolExample example);

    School selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExampleWithBLOBs(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKeyWithBLOBs(School record);

    int updateByPrimaryKey(School record);

    List<School> findSchoolBySchoolId(Integer id);

    void updateValidPeriod(School school);

    List<School> selectBySchoolName(String schoolName);

}