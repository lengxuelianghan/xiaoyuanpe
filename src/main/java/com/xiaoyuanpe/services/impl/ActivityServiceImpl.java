package com.xiaoyuanpe.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.ActivityMapper;
import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.pojo.ActivityEntry;
import com.xiaoyuanpe.pojo.ActivityExample;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.services.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;

    @Override
    public int addActivity(Activity activity) {
        return this.activityMapper.insert(activity);
    }

//    @Override
//    public PageInfo<ActivityEntry> findActivityAll(Page page, int schoolId, String columnName,Integer searchContent) {
//        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
//        PageInfo<ActivityEntry> studentInfoPage = new PageInfo<>(this.activityMapper.selectActivityAllWithSomething(schoolId,columnName,searchContent));
//        return studentInfoPage;
//    }

    @Override
    public Activity findActivityById(Integer id) {
        return this.activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyActivity(Activity activity) {
        this.activityMapper.updateByPrimaryKey(activity);
    }

    @Override
    public void DeleteActivityList(List<Integer> ids) {
        ids.forEach(id->this.activityMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<Activity> findActivityAllList() {
        ActivityExample activityExample = new ActivityExample();
        return this.activityMapper.selectByExample(activityExample);
    }

    @Override
    public List<Activity> findActivityAllListAfterDate() {
        List<Activity> activityList = new ArrayList<>();
        ActivityExample activityExample = new ActivityExample();
        for (Activity activity: this.activityMapper.selectByExample(activityExample)){
            if (activity.getEndTime().after(new Date())){
                activityList.add(activity);
            }
        }
        return activityList;
    }

    @Override
    public List<Activity> findActivityByUserId(Integer userId) {
        List<Activity> activityList = this.activityMapper.selectByExample(new ActivityExample());
        List<Activity> activities = new ArrayList<>();
        for (Activity activity: activityList){
            if (activity.getPublisherId() == userId){
                activities.add(activity);
            }
        }
        return activities;
    }

    @Override
    public PageInfo<ActivityEntry> findActivityAll(Page page, Integer schoolId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityEntry> studentInfoPage = new PageInfo<>(this.activityMapper.selectActivityAll(schoolId));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityEntry> selectActivityAllWithSomething(Page page, Integer schoolId, String columnName, String searchContent) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityEntry> studentInfoPage =
                new PageInfo<>(this.activityMapper.selectActivityAllWithSomething(schoolId,columnName, searchContent));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityEntry> selectActivityAllWithSomethingAttend(Page page, Integer schoolId, String columnName, String searchContent) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityEntry> studentInfoPage =
                new PageInfo<>(this.activityMapper.selectActivityAllWithSomethingAttend(schoolId,columnName, searchContent));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityEntry> selectActivityAllSignIn(Page page, Integer schoolId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityEntry> studentInfoPage = new PageInfo<>(this.activityMapper.selectActivityAllSignIn(schoolId));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityEntry> findActivityByStatus(Page page, Integer status, Integer schoolId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityEntry> studentInfoPage = new PageInfo<>(this.activityMapper.selectActivityAllSignIn(status));
        return studentInfoPage;
    }

}
