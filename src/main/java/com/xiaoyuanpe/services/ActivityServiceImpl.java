package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.ActivityMapper;
import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.units.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public void addActivity(Activity activity) {
        this.activityMapper.insert(activity);
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

}
