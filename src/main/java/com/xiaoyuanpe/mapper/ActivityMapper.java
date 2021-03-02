package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.pojo.ActivityEntry;
import com.xiaoyuanpe.pojo.ActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
    long countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<ActivityEntry> selectActivityAll(Integer schoolId);

    List<ActivityEntry> selectActivityAllWithSomething(@Param("schoolId") Integer schoolId,
                                                       @Param("columnName")String columnName,
                                                       @Param("searchContent")String searchContent);

    List<ActivityEntry> selectActivityAllWithSomethingAttend(@Param("schoolId") Integer schoolId,
                                                             @Param("columnName")String columnName,
                                                             @Param("searchContent")String searchContent);

    List<ActivityEntry> selectActivityAllSignIn(Integer schoolId);

    List<ActivityEntry> selectActivityByStatus(@Param("status")Integer status, @Param("schoolId") Integer schoolId);
}