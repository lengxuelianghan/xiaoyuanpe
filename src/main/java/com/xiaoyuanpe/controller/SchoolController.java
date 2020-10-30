package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.School;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.SchoolService;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/selectSchoolByUser")
    public ResultBean selectSchoolByUser(HttpSession session){
        ResultBean resultBean = new ResultBean();
        User user = (User) session.getAttribute("user");
        try {
            resultBean.setData(this.schoolService.findSchoolById(user.getSchoolId()));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println("错误"+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学校查找失败");
        }
        return resultBean;
    }

    @PostMapping("/addSchool")
    public ResultBean addSchool(@RequestBody School school){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.schoolService.addSchool(school);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println("错误" + e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学校添加失败");
            }
        }
        else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/querySchool/{id}")
    public ResultBean querySchool(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.schoolService.findSchoolById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println("错误"+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学校查找失败");
        }
        return resultBean;
    }

    @RequestMapping("/querySchoolList")
    public ResultBean querySchoolList(){
        Subject subject = SecurityUtils.getSubject();
        ResultBean resultBean = new ResultBean();
        try {
            boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager", "classmanager"," teacher", "student"));
            if (HasRole.hasOneRole(booleans)) {
                try {
                    resultBean.setData(this.schoolService.findSchoolAll());
                    resultBean.setCode(0);
                } catch (Exception e) {
                    System.out.println("错误" + e.getMessage());
                    resultBean.setCode(1);
                    resultBean.setMsg("学校列表查找失败");
                }
            }
            else {
                resultBean.setMsg("您们没有权限");
                resultBean.setCode(1);
            }
        }catch (Exception ee) {
            resultBean.setCode(1);
            resultBean.setMsg(ee.toString()+"," + subject.getPrincipal() +","+subject.hasRole("student"));
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateSchool", method = RequestMethod.POST)
    public ResultBean updateSchool(@RequestBody School school){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.schoolService.ModifySchool(school);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println("错误" + e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学校添更新失败");
            }
        }
        else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteSchool", method = RequestMethod.POST)
    public ResultBean deleteSchool(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.schoolService.DeleteSchoolList(ids);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println("错误" + e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学校添更新失败");
            }
        }
        else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
