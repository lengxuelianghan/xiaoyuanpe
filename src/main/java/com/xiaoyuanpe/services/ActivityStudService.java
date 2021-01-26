package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.ActivityStud;
import com.xiaoyuanpe.pojo.ActivityStudEntry;
import com.xiaoyuanpe.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityStudService {
    void addActivityStud(ActivityStud activityStud);

    ActivityStud findActivityStudById(Integer id);

    ActivityStud findByAIdAndSid(Integer aid, Integer sid);

    void ModifyActivityStud(ActivityStud activityStud);

    void DeleteActivityStudList(List<Integer> ids);

    List<ActivityStud>  findActivityStudAllList();
    PageInfo<ActivityStudEntry> selectActivityByOrganizer(Page page, @Param("studentId") Integer studentId);
    PageInfo<ActivityStudEntry> selectActivityByPartner(Page page, @Param("studentId") Integer studentId);

}
