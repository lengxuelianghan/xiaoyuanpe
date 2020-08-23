package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.College;
import com.xiaoyuanpe.services.CollegeService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @RequestMapping(value = "/addCollege", method = RequestMethod.POST)
    public ResultBean addCollege(@RequestBody College college){
        ResultBean resultBean = new ResultBean();
        try {
            this.collegeService.addCollege(college);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学院信息添加失败");
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
    @RequestMapping(value = "/queryCollegeList")
    public ResultBean queryCollegeList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.collegeService.findCollegeAll());
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学院列表信息查找失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/updateCollege", method = RequestMethod.POST)
    public ResultBean updateCollege(@RequestBody College college){
        ResultBean resultBean = new ResultBean();
        try {
            this.collegeService.ModifyCollege(college);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学院信息修改失败");
        }
        return resultBean;
    }
}
