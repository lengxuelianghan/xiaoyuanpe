package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Classes;
import com.xiaoyuanpe.services.ClassesService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/queryClassesList")
    public ResultBean queryClassesList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.classesService.findClassesAll());
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

}
