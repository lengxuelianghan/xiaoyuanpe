package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Sports;
import com.xiaoyuanpe.services.SportService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportService sportService;

    @PostMapping("/addSport")
    public ResultBean addSport(@RequestBody Sports sports){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.addSports(sports);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动信息添加错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/querySport/{id}")
    public ResultBean querySport(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportService.findSportsById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动查找错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/querySportList")
    public ResultBean querySportList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportService.findSportsAll());
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动列表查找错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateSport", method = RequestMethod.POST)
    public ResultBean updateSport(@RequestBody Sports sports){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.ModifySports(sports);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动修改错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
