package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.services.UserRoleService;
import com.xiaoyuanpe.services.UserService;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateUser {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;

    public void createUser(){
        try {
            List<User> usersListAll = userService.findUsersListAll();
            if (usersListAll == null || usersListAll.size() == 0) {
                User user = new User();
                user.setIdentity("网站管理员");
                user.setUsername("管理员");
                user.setUnit("无");
                user.setUserNumber("root");
                user.setPassword("123456");
                user.setPhone("无");
                userService.addUser(user);
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(1);
                userRoleService.addUserRole(userRole);
            }
        }catch (Exception e){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("C:/root.txt"));
                out.write(e.getMessage());
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
