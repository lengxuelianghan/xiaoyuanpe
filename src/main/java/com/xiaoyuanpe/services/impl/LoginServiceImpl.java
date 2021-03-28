package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.UserMapper;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Override
    public String login(String usenumber, String password, Integer schoolId) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(usenumber,password);
        String err = "登陆成功";
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            err = "登陆失败，用户名不存在";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            err = "登录失败：密码错误";
        }
        return err;
    }

    @Override
    public String login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        String err = "登陆成功";
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            err = "登陆失败，用户名不存在";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            err = "登录失败：密码错误";
        }
        return err;
    }
}
