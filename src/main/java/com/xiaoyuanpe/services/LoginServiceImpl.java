package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.UserMapper;
import com.xiaoyuanpe.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String usenumber, String password, Integer schoolId) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(usenumber+"_"+schoolId,password);
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
