package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Info;
import com.xiaoyuanpe.services.InfoService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @PostMapping("/addInfo")
    public ResultBean addInfo(@RequestBody Info info){
        ResultBean resultBean = new ResultBean();
        try {
            this.infoService.addInfo(info);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/updateInfo")
    public ResultBean updateInfo(@RequestBody Info info){
        ResultBean resultBean = new ResultBean();
        try {
            this.infoService.ModifyInfo(info);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/queryInfoList")
    public ResultBean updateInfo(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.infoService.findInfoAllList());
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/queryInfo/id")
    public ResultBean queryInfo(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.infoService.findInfoById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }
}
