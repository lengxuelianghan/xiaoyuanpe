package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Business;
import com.xiaoyuanpe.services.BusinessService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @PostMapping("/addBusiness")
    public ResultBean addBusiness(@RequestBody Business business){
        ResultBean resultBean = new ResultBean();
        try {
            this.businessService.addBusiness(business);
            resultBean.setCode(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("商品信息添加失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryBusiness/{id}")
    public ResultBean queryBusiness(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.businessService.findBusinessById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("商品信息查询失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryBusinessList/{current}/{pageSize}")
    public ResultBean queryBusinessList(@PathVariable Integer current, @PathVariable Integer pageSize){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.businessService.findBusinessAll(current, pageSize));
            resultBean.setCode(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("商品信息列表查询失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateBusiness", method = RequestMethod.POST)
    public ResultBean updateBusiness(@RequestBody Business business){
        ResultBean resultBean = new ResultBean();
        try {
            this.businessService.ModifyBusiness(business);
            resultBean.setCode(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("商品信息修改失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteBusiness", method = RequestMethod.POST)
    public ResultBean deleteBusiness(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            this.businessService.DeleteBusinessList(ids);
            resultBean.setCode(1);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("商品信息修改失败");
        }
        return resultBean;
    }
}
