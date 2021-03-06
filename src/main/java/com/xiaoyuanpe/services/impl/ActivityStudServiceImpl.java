package com.xiaoyuanpe.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.ActivityStudMapper;
import com.xiaoyuanpe.pojo.ActivityStud;
import com.xiaoyuanpe.pojo.ActivityStudEntry;
import com.xiaoyuanpe.pojo.ActivityStudExample;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.services.ActivityStudService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityStudServiceImpl implements ActivityStudService {
    @Resource
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

    @Override
    public List<ActivityStud> findActivityStudAllByActivityId(Integer aid) {
        return this.activityStudMapper.selectByAid(aid);
    }

    @Override
    public PageInfo<ActivityStudEntry> selectActivityByOrganizer(Page page, Integer studentId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityStudEntry> studentInfoPage = new PageInfo<>(this.activityStudMapper.selectActivityByOrganizer(studentId));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityStudEntry> selectActivityByOrganizerWithStatus(Page page, Integer studentId, Integer status) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityStudEntry> studentInfoPage = new PageInfo<>(
                this.activityStudMapper.selectActivityByOrganizerWithStatus(studentId, status));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityStudEntry> selectActivityByPartner(Page page, Integer studentId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityStudEntry> studentInfoPage = new PageInfo<>(this.activityStudMapper.selectActivityByPartner(studentId));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityStudEntry> selectActivityBySignin(Page page, Integer studentId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityStudEntry> studentInfoPage = new PageInfo<>(this.activityStudMapper.selectActivityBySignin(studentId));
        return studentInfoPage;
    }

    @Override
    public PageInfo<ActivityStudEntry> selectPartnerByActivity(Page page, Integer activityId) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<ActivityStudEntry> studentInfoPage = new PageInfo<>(this.activityStudMapper.selectPartnerByActivity(activityId));
        return studentInfoPage;
    }
}
