package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.ActivityStudMapper;
import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.pojo.ActivityStud;
import com.xiaoyuanpe.pojo.ActivityStudExample;
import com.xiaoyuanpe.units.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityStudServiceImpl implements ActivityStudService {
    @Autowired
    private ActivityStudMapper activityStudMapper;

    @Override
    public void addActivityStud(ActivityStud activityStud) {
        this.activityStudMapper.insert(activityStud);
    }

    @Override
    public ActivityStud findActivityStudById(Integer id) {
        return this.activityStudMapper.selectByPrimaryKey(id);
    }

    @Override
    public ActivityStud findByAIdAndSid(Integer aid, Integer sid) {
        return this.activityStudMapper.selectByAidAndSid(aid, sid);
    }

    @Override
    public void ModifyActivityStud(ActivityStud activityStud) {
        this.activityStudMapper.updateByPrimaryKey(activityStud);
    }

    @Override
    public void DeleteActivityStudList(List<Integer> ids) {

    }

    @Override
    public List<ActivityStud> findActivityStudAllList() {
        ActivityStudExample activityStudExample = new ActivityStudExample();
        return this.activityStudMapper.selectByExample(activityStudExample);
    }
}
