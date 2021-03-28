package com.xiaoyuanpe.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.mapper.SigninMapper;
import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SignInServiceImpl implements SignInService {

    @Resource
    private SigninMapper signinMapper;
    @Resource
    private StudentMapper studentMapper;

    @Override
    public void addSignin(Signin signin) {
        this.signinMapper.insert(signin);
    }

    @Override
    public List<Signin> findSigninAll() {
        SigninExample signinExample = new SigninExample();
        return this.signinMapper.selectByExample(signinExample);
    }

    @Override
    public Signin findSigninById(Integer id) {
        return this.signinMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifySignin(Signin school) {
        this.signinMapper.updateByPrimaryKey(school);
    }

    @Override
    public void DeleteSignin(Integer id) {

    }

    @Override
    public void DeleteSigninList(List<Integer> ids) {

    }

    @Override
    public Integer searchActivityOneWeekActivity(Integer studentId, Integer clazz) {
        return this.signinMapper.searchActivityOneWeekActivity(studentId, clazz);
    }

    @Override
    public Integer searchActivityOneWeekSport(Integer studentId) {
        return this.signinMapper.searchActivityOneWeekSport(studentId);
    }

    @Override
    public PageInfo<StudentInfoEntry> searchSignInSport(Integer sportId, Integer collegeId, Integer classId, Page page) {
        PageHelper.startPage(page.getCurrentPageNumber(), page.getPageSize(), page.getSort());
        PageInfo<StudentInfoEntry> studentInfoPage = new PageInfo<>(this.signinMapper.searchSignInSport(sportId, collegeId, classId));
        return studentInfoPage;
    }

}
