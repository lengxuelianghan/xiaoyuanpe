package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.ActivityStud;
import com.xiaoyuanpe.pojo.ActivityStudExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityStudMapper {
    long countByExample(ActivityStudExample example);

    int deleteByExample(ActivityStudExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityStud record);

    int insertSelective(ActivityStud record);

    List<ActivityStud> selectByExample(ActivityStudExample example);

    ActivityStud selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityStud record, @Param("example") ActivityStudExample example);

    int updateByExample(@Param("record") ActivityStud record, @Param("example") ActivityStudExample example);

    int updateByPrimaryKeySelective(ActivityStud record);

    int updateByPrimaryKey(ActivityStud record);
}