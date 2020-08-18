package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Role;
import com.xiaoyuanpe.services.RoleService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/addUser")
    public ResultBean addRole(@RequestBody Role role){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            this.roleService.addRole(role);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("角色添加失败");
            System.out.println("错误:"+e.getMessage());
        }
        return resultBean;
    }

    @RequestMapping("/queryRole/{id}")
    public ResultBean queryRole(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            resultBean.setData(this.roleService.findRoleById(id));
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("角色查找失败");
            System.out.println("错误:"+e.getMessage());
        }
        return resultBean;
    }

    @RequestMapping("/queryRoleList")
    public ResultBean queryRoleList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            resultBean.setData(this.roleService.findRoleAll());
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("角色列表查找失败");
            System.out.println("错误:"+e.getMessage());
        }
        return resultBean;
    }

}
