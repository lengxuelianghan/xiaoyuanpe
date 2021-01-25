package com.xiaoyuanpe.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.ActivityMapper;
import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.units.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int addActivity(Activity activity) {
        return this.activityMapper.insert(activity);
    }

    @Override
    public Pager<Activity> findActivityAll(int current, int pageSize) {
        ActivityExample activityExample = new ActivityExample();
        List<Activity> activities = this.activityMapper.selectByExample(activityExample);
        Pager<Activity> pager = new Pager<>();
        pager.setCurrentPage(current);
        pager.setPageSize(pageSize);
        int totalNum = (int)this.activityMapper.countByExample(activityExample);
        pager.setRecordTotal(totalNum);
        if (current * pageSize < totalNum) {
            pager.setContent(activities.subList((current - 1) * pageSize, current * pageSize));
        }
        else {
            if ((current - 1) * pageSize <= totalNum){
                pager.setContent(activities.subList((current - 1) * pageSize, totalNum));
            }
            else {
                pager.setContent(null);
            }

        }
        return pager;
    }

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
    public PageInfo<ActivityEntry> selectActivityAllWithSomething(Page page, Integer schoolId, String columnName, Integer searchContent) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityEntry> studentInfoPage = new PageInfo<>(this.activityMapper.selectActivityAllWithSomething(schoolId,columnName, searchContent));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityEntry> selectActivityAllSignIn(Page page, Integer schoolId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityEntry> studentInfoPage = new PageInfo<>(this.activityMapper.selectActivityAllSignIn(schoolId));
        return studentInfoPage;
    }

}
