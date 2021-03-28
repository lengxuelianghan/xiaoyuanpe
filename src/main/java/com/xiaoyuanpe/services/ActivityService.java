package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.pojo.ActivityEntry;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.units.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {

    int addActivity(Activity activity);

//    PageInfo<ActivityEntry>  findActivityAll(Page page,int schoolId, String columnName,Integer searchContent);

    Activity findActivityById(Integer id);

    void ModifyActivity(Activity activity);

    void DeleteActivityList(List<Integer> ids);

    List<Activity>  findActivityAllList();

    List<Activity>  findActivityAllListAfterDate();

    List<Activity>  findActivityByUserId(Integer userId);

    PageInfo<ActivityEntry> findActivityAll(Page page, Integer schoolId);

    PageInfo<ActivityEntry> selectActivityAllWithSomething(Page page, Integer schoolId, String columnName,String searchContent);

    PageInfo<ActivityEntry> selectActivityAllWithSomethingAttend(Page page, Integer schoolId, String columnName,String searchContent);

    PageInfo<ActivityEntry> selectActivityAllSignIn(Page page, Integer schoolId);

    PageInfo<ActivityEntry> findActivityByStatus(Page page, Integer status, Integer schoolId);
}
