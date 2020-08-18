package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.UserMapper;
import com.xiaoyuanpe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String usenumber, String password) {
        User user = this.userMapper.selectByPrimaryNumber(usenumber);
        String err = "登陆成功";
        if (user!=null){
            if (!user.getPassword().equals(password)){
                err = "登录失败：密码错误";
            }
        }
        else {
            err = "登陆失败，用户名不存在";
        }
        return err;
    }
}
