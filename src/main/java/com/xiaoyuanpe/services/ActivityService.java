package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.pojo.ActivityEntry;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface ActivityService {

    int addActivity(Activity activity);

    Pager<Activity> findActivityAll(int current, int pageSize);

    Activity findActivityById(Integer id);

    void ModifyActivity(Activity activity);

    void DeleteActivityList(List<Integer> ids);

    List<Activity>  findActivityAllList();

    List<Activity>  findActivityAllListAfterDate();

    List<Activity>  findActivityByUserId(Integer userId);

    PageInfo<ActivityEntry> findActivityAll(Page page, Integer schoolId);

}
