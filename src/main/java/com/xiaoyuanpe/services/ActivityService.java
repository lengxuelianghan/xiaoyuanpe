package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface ActivityService {

    int addActivity(Activity activity);

    Pager<Activity> findActivityAll(int current, int pageSize);

    Activity findActivityById(Integer id);

    void ModifyActivity(Activity activity);

    void DeleteActivityList(List<Integer> ids);

    List<Activity>  findActivityAllList();

}
