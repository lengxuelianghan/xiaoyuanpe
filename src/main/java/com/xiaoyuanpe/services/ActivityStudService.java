package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.ActivityStud;

import java.util.List;

public interface ActivityStudService {
    void addActivityStud(ActivityStud activityStud);

    ActivityStud findActivityStudById(Integer id);

    ActivityStud findByAIdAndSid(Integer aid, Integer sid);

    void ModifyActivityStud(ActivityStud activityStud);

    void DeleteActivityStudList(List<Integer> ids);

    List<ActivityStud>  findActivityStudAllList();
}
