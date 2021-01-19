package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Page;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public ResultBean addSchool(@RequestBody School school, HttpServletRequest servletRequest){
        User user = (User)  servletRequest.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("supermanager"));
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


    @RequestMapping("/querySchoolValidPeriod")
    public ResultBean querySchoolValidPeriod(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                resultBean.setData(this.schoolService.findSchoolById(user.getSchoolId()).getValidPeriod());
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println("错误" + e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学校查找失败");
            }
        }else {
            resultBean.setMsg("您没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    //模糊查询学校信息
    @RequestMapping("/searchSchool/{schoolName}")
    public ResultBean searchSchool(@PathVariable String schoolName){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                resultBean.setData(this.schoolService.selectBySchoolName(schoolName));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println("错误" + e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学校查找失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("您没有权限");
        }
        return resultBean;
    }


    @RequestMapping(value = "/querySchoolList", method = RequestMethod.POST)
    public ResultBean querySchoolList(@RequestBody Page page){
        ResultBean resultBean = new ResultBean();
                try {
                    resultBean.setData(this.schoolService.findSchoolAll(page));
                    resultBean.setCode(0);
                } catch (Exception e) {
                    System.out.println("错误" + e.getMessage());
                    resultBean.setCode(1);
                    resultBean.setMsg("学校列表查找失败");
                }
        return resultBean;
    }

    @RequestMapping(value = "/querySchoolList", method = RequestMethod.GET)
    public ResultBean querySchoolList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.schoolService.findSchoolAll());
            resultBean.setCode(0);
        } catch (Exception e) {
            System.out.println("错误" + e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学校列表查找失败");
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
        boolean[] booleans = subject.hasRoles(Arrays.asList("supermanager"));
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

    @RequestMapping(value = "/updateValidPeriod", method = RequestMethod.POST)
    public ResultBean updateValidPeriod(@RequestBody School school){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.schoolService.ModifyValidPeriod(school);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println("错误" + e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学期失败");
            }
        }
        else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
