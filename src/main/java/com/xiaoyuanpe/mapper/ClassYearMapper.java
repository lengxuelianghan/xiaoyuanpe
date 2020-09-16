package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.ClassYear;
import com.xiaoyuanpe.pojo.ClassYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassYearMapper {
    long countByExample(ClassYearExample example);

    int deleteByExample(ClassYearExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassYear record);

    int insertSelective(ClassYear record);

    List<ClassYear> selectByExample(ClassYearExample example);

    ClassYear selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassYear record, @Param("example") ClassYearExample example);

    int updateByExample(@Param("record") ClassYear record, @Param("example") ClassYearExample example);

    int updateByPrimaryKeySelective(ClassYear record);

    int updateByPrimaryKey(ClassYear record);
}