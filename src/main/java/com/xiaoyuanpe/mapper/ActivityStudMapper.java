package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.ActivityStud;
import com.xiaoyuanpe.pojo.ActivityStudEntry;
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

    ActivityStud selectByAidAndSid(@Param("aid") Integer aid, @Param("sid") Integer sid);

    List<ActivityStud> selectByAid(@Param("aid") Integer aid);

    int updateByExampleSelective(@Param("record") ActivityStud record, @Param("example") ActivityStudExample example);

    int updateByExample(@Param("record") ActivityStud record, @Param("example") ActivityStudExample example);

    int updateByPrimaryKeySelective(ActivityStud record);

    int updateByPrimaryKey(ActivityStud record);

    List<ActivityStudEntry> selectActivityByOrganizer(@Param("studentId") Integer studentId);

    List<ActivityStudEntry> selectActivityByOrganizerWithStatus(@Param("studentId") Integer studentId,
                                                                @Param("status")  Integer status);

    List<ActivityStudEntry> selectActivityByPartner(@Param("studentId") Integer studentId);

    List<ActivityStudEntry> selectActivityBySignin(@Param("studentId") Integer studentId);

    List<ActivityStudEntry> selectPartnerByActivity(@Param("activityId") Integer activityId);
}