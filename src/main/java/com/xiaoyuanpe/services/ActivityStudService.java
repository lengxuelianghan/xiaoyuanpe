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
    List<ActivityStud>  findActivityStudAllByActivityId(Integer aid);
    PageInfo<ActivityStudEntry> selectActivityByOrganizer(Page page, Integer studentId);
    PageInfo<ActivityStudEntry> selectActivityByOrganizerWithStatus(Page page,Integer studentId, Integer status);
    PageInfo<ActivityStudEntry> selectActivityByPartner(Page page, Integer studentId);
    PageInfo<ActivityStudEntry> selectActivityBySignin(Page page, Integer studentId);
    PageInfo<ActivityStudEntry> selectPartnerByActivity(Page page, Integer activityId);

}
