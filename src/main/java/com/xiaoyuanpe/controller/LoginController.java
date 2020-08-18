package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.LoginService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResultBean Login(@RequestParam String usernumber, @RequestParam String password, HttpSession session){

        ResultBean resultBean = new ResultBean();
        try {
            String info = this.loginService.login(usernumber, password);
            for (User user : this.userService.findUsersAll()) {
                if (usernumber.equals(user.getEmail())) {
                    session.setAttribute("user", user);
                }
            }
            resultBean.setCode(0);
            resultBean.setMsg(info);
        }catch (Exception e){
            System.out.println("错误："+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("登录失败");
        }
        return resultBean;
    }

}
