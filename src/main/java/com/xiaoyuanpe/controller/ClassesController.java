package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Classes;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.ClassesService;
import com.xiaoyuanpe.services.StudentService;
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
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/addClasses", method = RequestMethod.POST)
    public ResultBean addClasses(@RequestBody Classes classes){
        Subject subject = SecurityUtils.getSubject();
        ResultBean resultBean = new ResultBean();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.classesService.addClasses(classes);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("班级信息添加失败");
            }
        }
        else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryClasses/{id}")
    public ResultBean queryClasses(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.classesService.findClassesById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("班级信息查找失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryClassesListBySchool", method = RequestMethod.POST)
    public ResultBean queryClassesListBySchool(@RequestBody Page page, HttpServletRequest session){
        User user = (User) session.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.classesService.selectBySchool(page, user.getSchoolId()));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("班级列表信息添加失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryClassesListByCollege", method = RequestMethod.POST)
    public ResultBean queryClassesListByList(@RequestBody Page page, HttpServletRequest session){
        User user = (User) session.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            Student student = this.studentService.findStudentByNumber(user.getUserNumber());
            resultBean.setData(this.classesService.selectByCollege(page, student.getCollegeId()));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("班级列表信息添加失败");
        }
        return resultBean;
    }


    @RequestMapping(value = "/updateClasses", method = RequestMethod.POST)
    public ResultBean updateClasses(@RequestBody Classes classes){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.classesService.ModifyClasses(classes);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("班级信息更新失败");
            }
        }else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteClasses", method = RequestMethod.POST)
    public ResultBean deleteClasses(@RequestBody List<Integer> ids){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.classesService.DeleteClassesList(ids);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("班级信息更新失败");
            }
        }else {
            resultBean.setMsg("您们没有权限");
            resultBean.setCode(1);
        }
        return resultBean;
    }

}
