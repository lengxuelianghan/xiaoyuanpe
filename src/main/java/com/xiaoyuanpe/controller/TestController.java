package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.services.ActivityService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ActivityService activityService;
    @RequestMapping("/login")
    public String Login(){
        System.out.println();
        return "login";
    }
    @RequestMapping("/assign")
    public String assign(){
        int a = 0x122;
        System.out.println(a/2);
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

    @RequestMapping("/getTime")
    public ResultBean getTime(){
        Date[] dates=new Date[3];
        ResultBean resultBean = new ResultBean();
        Date date = new Date();
        dates[0] =  new Date(date.getTime()+8*60*60*1000);
        dates[1] = this.activityService.findActivityById(11).getRegistrationStartTime();
        dates[2] = this.activityService.findActivityById(11).getRegistrationClosingTime();
        resultBean.setData(dates);
        return resultBean;
    }
}
