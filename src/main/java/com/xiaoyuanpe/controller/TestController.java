package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.services.LoginService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/login")
    public String Login(){
        System.out.println();
        return "login";
    }
    @RequestMapping("/assign")
    public String assign(){
        System.out.println();
        return "assign";
    }

    @PostMapping("/login1")
    public String Login1(@RequestParam String usernumber, @RequestParam String password, Model model){
        ResultBean resultBean = new ResultBean();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(usernumber, password);
        try {
            subject.login(token);
            model.addAttribute("msg","登陆成功");
        }catch (UnknownAccountException e){
            model.addAttribute("msg","登录名不存在！");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误！");
            return "login";
        }
        return "login";
    }
}
