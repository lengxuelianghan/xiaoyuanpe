package com.xiaoyuanpe;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.services.UserRoleService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.ApplicationContextUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.xiaoyuanpe.mapper")//指定扫描接口与配置文件的包名
public class XiaoyuanpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoyuanpeApplication.class, args);
        try {
            UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
            UserRoleService userRoleService = (UserRoleService) ApplicationContextUtils.getBean("userRoleService");
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
           System.out.println(e.getMessage());
        }
    }

}