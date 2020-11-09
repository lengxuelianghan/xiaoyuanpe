package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Healthmanagement;
import com.xiaoyuanpe.pojo.HealthmanagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HealthmanagementMapper {
    long countByExample(HealthmanagementExample example);

    int deleteByExample(HealthmanagementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Healthmanagement record);

    int insertSelective(Healthmanagement record);

    List<Healthmanagement> selectByExample(HealthmanagementExample example);

    Healthmanagement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Healthmanagement record, @Param("example") HealthmanagementExample example);

    int updateByExample(@Param("record") Healthmanagement record, @Param("example") HealthmanagementExample example);

    int updateByPrimaryKeySelective(Healthmanagement record);

    int updateByPrimaryKey(Healthmanagement record);
}