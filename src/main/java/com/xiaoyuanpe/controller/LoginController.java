package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.School;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserEntry;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/login")
    public ResultBean Login(@RequestParam Integer schoolId, @RequestParam String usernumber,
                            @RequestParam String password, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            int pageSize = (int)this.userService.Count();
            String info = "登陆失败，学校选择失败";
            if (schoolId==this.userService.findUsersByStudentNum(usernumber).getSchoolId()) {
                info = this.loginService.login(usernumber, password, schoolId);
            }
            if (info.equals("登陆成功")) {
                resultBean.setCode(0);
                User user = this.userService.findUsersByStudentNum(usernumber);
                    if (usernumber.equals(user.getUserNumber())) {
                        session.setAttribute("user", user);
                        session.setMaxInactiveInterval(30 * 60 * 60);
                        resultBean.setTotal(user.getId());
                        UserEntry userEntry = new UserEntry();
                        userEntry.setId(user.getId());
                        userEntry.setUsername(user.getUsername());
                        userEntry.setAge(user.getAge());
                        userEntry.setEmail(user.getEmail());
                        userEntry.setSex(user.getSex());
                        userEntry.setPhone(user.getPhone());
                        userEntry.setIdentity(user.getIdentity());
                        userEntry.setPassword(user.getPassword());
                        userEntry.setSchoolId(this.schoolService.findSchoolById(user.getSchoolId()).getSchoolName());
                        userEntry.setUnit(user.getUnit());
                        userEntry.setUserNumber(user.getUserNumber());
                        resultBean.setData(userEntry);
                }
            }
            else
                resultBean.setCode(1);
            resultBean.setMsg(info);
        }catch (Exception e){
            System.out.println("错误："+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("登录失败");
        }
        return resultBean;
    }

    @PostMapping("/loginManager")
    public ResultBean loginManager(@RequestParam String usernumber, @RequestParam String password, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            String info = "非管理员，无法登录";
            User username = this.userService.findRolesByUsername(usernumber);
            if (username!=null) {
                List<UserRole> userRoleByUserId = this.userRoleService.findUserRoleByUserId(username.getId());
                for (UserRole userRole: userRoleByUserId){
                    if (userRole.getRoleId()==1){
                        info = this.loginService.login(usernumber, password);
                        break;
                    }
                }
            }
            else info="用户不存在";
            if (info.equals("登陆成功")) {
                resultBean.setCode(0);
                User user = this.userService.findUsersByStudentNum(usernumber);
                    if (usernumber.equals(user.getUserNumber())) {
                        session.setAttribute("user", user);
                        session.setMaxInactiveInterval(30 * 60 * 60);
                        resultBean.setTotal(user.getId());
                        UserEntry userEntry = new UserEntry();
                        userEntry.setId(user.getId());
                        userEntry.setUsername(user.getUsername());
                        userEntry.setAge(user.getAge());
                        userEntry.setEmail(user.getEmail());
                        userEntry.setSex(user.getSex());
                        userEntry.setPhone(user.getPhone());
                        userEntry.setIdentity(user.getIdentity());
                        userEntry.setPassword(user.getPassword());
                        userEntry.setSchoolId(this.schoolService.findSchoolById(user.getSchoolId()).getSchoolName());
                        userEntry.setUnit(user.getUnit());
                        userEntry.setUserNumber(user.getUserNumber());
                        resultBean.setData(userEntry);
                }
            }
            else
                resultBean.setCode(2);
            resultBean.setMsg(info);
        }catch (Exception e){
            System.out.println("错误："+e.getMessage());
            resultBean.setCode(2);
            resultBean.setMsg("登录失败!!");
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
                resultBean.setData(user);
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
    @RequestMapping("/loginFaild")
    public ResultBean loginFaild(){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-1);
        resultBean.setMsg("您已退出登录！");
        return resultBean;
    }

}
