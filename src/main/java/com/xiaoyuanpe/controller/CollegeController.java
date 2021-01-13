package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.College;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.CollegeService;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @RequestMapping(value = "/addCollege", method = RequestMethod.POST)
    public ResultBean addCollege(@RequestBody College college, HttpServletRequest servletRequest){
        User user = (User) servletRequest.getSession().getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                college.setShcoolId(user.getSchoolId());
                this.collegeService.addCollege(college);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学院信息添加失败");
            }
        }else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryCollege/{id}")
    public ResultBean queryCollege(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.collegeService.findCollegeById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学院信息查找失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryCollegeList", method = RequestMethod.POST)
    public ResultBean queryCollegeListBySchool(@RequestBody Page page, HttpServletRequest session){
        User user = (User) session.getSession().getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                resultBean.setData(this.collegeService.findCollegeAll(page, user.getSchoolId()));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学院列表信息查找失败"+e.getMessage());
            }
        }
        else {
            resultBean.setCode(1);
            resultBean.setMsg("没有权限");
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateCollege", method = RequestMethod.POST)
    public ResultBean updateCollege(@RequestBody College college){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.collegeService.ModifyCollege(college);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学院信息修改失败");
            }
        }else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteCollege", method = RequestMethod.POST)
    public ResultBean deleteCollege(@RequestBody List<Integer> ids){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                System.out.println(ids.toString());
                this.collegeService.DeleteCollegeList(ids);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学院信息修改失败");
            }
        }else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
