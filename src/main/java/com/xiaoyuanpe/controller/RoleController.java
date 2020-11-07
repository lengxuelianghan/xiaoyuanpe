package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Role;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.services.RoleService;
import com.xiaoyuanpe.services.StudentService;
import com.xiaoyuanpe.services.UserRoleService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    @PostMapping("/addRole")
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

    @RequestMapping("/updateRole")
    public ResultBean updateRole(@RequestBody Role role){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            this.roleService.ModifyRole(role);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("角色修改失败");
            System.out.println("错误:"+e.getMessage());
        }
        return resultBean;
    }

    @RequestMapping("/assentRole/{RoleName}/{id}")
    public ResultBean assentRole(@PathVariable String RoleName, @PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        UserRole userRole = new UserRole();
        User user = this.userService.findUsersById(id);
        if (RoleName.equals("学校管理员")) {
            boolean[] booleans = subject.hasRoles(Arrays.asList("supermanager"));
            if (HasRole.hasOneRole(booleans)){
                try {
                    userRole.setUserId(user.getId());
                    userRole.setRoleId(2);
                    this.userRoleService.addUserRole(userRole);
                    resultBean.setCode(0);
                    resultBean.setMsg("权限分配成功");
                }catch (Exception e){
                    resultBean.setCode(1);
                    resultBean.setMsg("权限分配失败");
                }
            }else {
                resultBean.setCode(1);
                resultBean.setMsg("没有权限");
            }
        }else if (RoleName.equals("教师")){
            boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager"));
            if (HasRole.hasOneRole(booleans)) {
                try {
                    userRole.setUserId(user.getId());
                    userRole.setRoleId(3);
                    this.userRoleService.addUserRole(userRole);
                    resultBean.setCode(0);
                    resultBean.setMsg("权限分配成功");
                } catch (Exception e) {
                    resultBean.setCode(1);
                    resultBean.setMsg("权限分配失败");
                }
            }else {
                resultBean.setCode(1);
                resultBean.setMsg("没有权限");
            }
        }else if (RoleName.equals("班级管理员")){
            boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager", "teacher"));
            if (HasRole.hasOneRole(booleans)) {
                try {
                    userRole.setUserId(user.getId());
                    userRole.setRoleId(4);
                    this.userRoleService.addUserRole(userRole);
                    resultBean.setCode(0);
                    resultBean.setMsg("权限分配成功");
                } catch (Exception e) {
                    resultBean.setCode(1);
                    resultBean.setMsg("权限分配失败");
                }
            }else {
                resultBean.setCode(1);
                resultBean.setMsg("没有权限");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("角色不存在");
        }
        return resultBean;
    }

}
