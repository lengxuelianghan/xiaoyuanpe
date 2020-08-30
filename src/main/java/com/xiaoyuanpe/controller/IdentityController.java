package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Identities;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.IdentityService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identity")
public class IdentityController {
    @Autowired
    private IdentityService identityService;
    @Autowired
    private UserService userService;

    @PostMapping("/addIdentity")
    public ResultBean addIdentity(@RequestBody Identities identities){
        ResultBean resultBean = new ResultBean();
        try {
            this.identityService.addIdentities(identities);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("身份信息插入失败");
        }
        return resultBean;
    }
    @RequestMapping("/queryIdentity/{id}")
    public ResultBean queryIdentity(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.identityService.findIdentitiesById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("身份信息查找失败");
        }
        return resultBean;
    }
    @RequestMapping("/queryIdentityList")
    public ResultBean queryIdentityList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.identityService.findIdentitiesAll());
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("身份列表信息查找失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/updateIdentity", method = RequestMethod.POST)
    public ResultBean updateIdentity(@RequestBody Identities identities){
        ResultBean resultBean = new ResultBean();
        try {
            this.identityService.ModifyIdentities(identities);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("身份信息更新失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/assignIdentity/{id}", method = RequestMethod.POST)
    public ResultBean assignIdentity(@PathVariable Integer id, @RequestBody String identities){
        ResultBean resultBean = new ResultBean();
        try {
           Boolean b = this.identityService.assignIdentity(id, identities);
           if (b){
               resultBean.setCode(0);
           }
           else {
               resultBean.setCode(1);
               resultBean.setMsg("身份信息分配失败");
           }
        }catch (Exception e){
            System.out.println("错误:"+e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("身份信息分配失败");
        }
        return resultBean;
    }
}
