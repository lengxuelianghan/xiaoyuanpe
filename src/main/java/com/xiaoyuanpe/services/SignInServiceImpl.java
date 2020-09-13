package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.SigninMapper;
import com.xiaoyuanpe.pojo.Signin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private SigninMapper signinMapper;
    @Override
    public void addSignin(Signin signin) {
        this.signinMapper.insert(signin);
    }

    @Override
    public List<Signin> findSigninAll() {
        return null;
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
