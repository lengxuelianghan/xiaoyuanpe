package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SigninMapper;
import com.xiaoyuanpe.mapper.StudentMapper;
import com.xiaoyuanpe.pojo.Signin;
import com.xiaoyuanpe.pojo.SigninExample;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private SigninMapper signinMapper;
    @Autowired
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

}
