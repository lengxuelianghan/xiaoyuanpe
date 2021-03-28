package com.xiaoyuanpe.units;

import com.xiaoyuanpe.XiaoyuanpeApplication;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserRole;
import com.xiaoyuanpe.services.UserRoleService;
import com.xiaoyuanpe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Order(value = 1)
public class CreateUser implements ApplicationRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        XiaoyuanpeApplication.roleSet(userService, userRoleService);
    }
}
