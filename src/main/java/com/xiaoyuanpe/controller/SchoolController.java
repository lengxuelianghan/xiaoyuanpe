package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.School;
import com.xiaoyuanpe.services.SchoolService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/addSchool")
    public ResultBean addSchool(@RequestBody School school){
        ResultBean resultBean = new ResultBean();
        try {
            this.schoolService.addSchool(school);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println("错误"+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学校添加失败");
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
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.schoolService.findSchoolAll());
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println("错误"+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学校列表查找失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateSchool", method = RequestMethod.POST)
    public ResultBean updateSchool(@RequestBody School school){
        ResultBean resultBean = new ResultBean();
        try {
            this.schoolService.ModifySchool(school);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println("错误"+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学校添更新失败");
        }
        return resultBean;
    }
}
