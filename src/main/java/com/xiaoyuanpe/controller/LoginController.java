package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserEntry;
import com.xiaoyuanpe.services.LoginService;
import com.xiaoyuanpe.services.SchoolService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.ibatis.jdbc.Null;
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
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/login")
    public ResultBean Login(@RequestParam String usernumber, @RequestParam String password, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(1);
            int pageSize = (int)this.userService.Count();
            String info = this.loginService.login(usernumber, password);
            for (User user : this.userService.findUsersAll(1,pageSize).getContent()) {
                if (usernumber.equals(user.getUserNumber())) {
                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(30*60*60);
                    resultBean.setCode(0);
                    resultBean.setTotal(user.getId());
                    UserEntry userEntry = new UserEntry();
                    userEntry.setId(user.getId());userEntry.setUsername(user.getUsername());
                    userEntry.setAge(user.getAge());userEntry.setEmail(user.getEmail());userEntry.setSex(user.getSex());
                    userEntry.setPhone(user.getPhone());userEntry.setIdentity(user.getIdentity());
                    userEntry.setPassword(user.getPassword());
                    userEntry.setSchoolId(this.schoolService.findSchoolById(user.getSchoolId()).getSchoolName());
                    userEntry.setUnit(user.getUnit());userEntry.setUserNumber(user.getUserNumber());
                    resultBean.setData(userEntry);
                    break;
                }
            }
            resultBean.setMsg(info);
        }catch (Exception e){
            System.out.println("错误："+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("登录失败");
        }
        return resultBean;
    }
    @RequestMapping("/logout")
    public ResultBean logout(HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            session.removeAttribute("user");
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println("错误："+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("登录失败");
        }
        return resultBean;
    }

    @RequestMapping("/LoginOrNot")
    public ResultBean LoginOrNot(HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            User user = (User) session.getAttribute("user");
            if (user!= null){
                resultBean.setCode(0);
                resultBean.setMsg("已登陆");
            }
            else {
                resultBean.setCode(1);
                resultBean.setMsg("未登录");
            }
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

}
