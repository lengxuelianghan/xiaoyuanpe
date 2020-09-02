package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Classes;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.ClassesService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    @RequestMapping(value = "/addClasses", method = RequestMethod.POST)
    public ResultBean addClasses(@RequestBody Classes classes){
        ResultBean resultBean = new ResultBean();
        try {
            this.classesService.addClasses(classes);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("班级信息添加失败");
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

    @RequestMapping(value = "/queryClassesList/{cid}")
    public ResultBean queryClassesList(@PathVariable Integer cid, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            List<Classes> classesList = new ArrayList<>();
            List<Classes> classes = this.classesService.findClassesAll();
            for (Classes classes1: classes){
                if ((classes1.getCollegeId()==cid)&&(classes1.getSchoolId()==user.getSchoolId())){
                    classesList.add(classes1);
                }
            }
            resultBean.setData(classesList);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("班级列表信息添加失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryClassesList/{sid}/{cid}")
    public ResultBean queryClassesListByList(@PathVariable Integer sid, @PathVariable Integer cid){
        ResultBean resultBean = new ResultBean();
        try {
            List<Classes> classesList = new ArrayList<>();
            List<Classes> classes = this.classesService.findClassesAll();
            for (Classes classes1: classes){
                if ((classes1.getCollegeId()==cid)&&(classes1.getSchoolId()==sid)){
                    classesList.add(classes1);
                }
            }
            resultBean.setData(classesList);
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
        ResultBean resultBean = new ResultBean();
        try {
            this.classesService.ModifyClasses(classes);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("班级信息更新失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteClasses", method = RequestMethod.POST)
    public ResultBean deleteClasses(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            this.classesService.DeleteClassesList(ids);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("班级信息更新失败");
        }
        return resultBean;
    }

}
