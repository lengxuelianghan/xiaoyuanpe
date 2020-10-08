package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Realm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加授权资源字符串
        info.addStringPermission("user:add");

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName="";
        List<User> users = this.userService.findUsersListAll();
        String password="";
        int b=0;
        for (User user: users) {
            if (token.getUsername().equals(user.getUsername())) {
                b=1;
                userName = user.getUsername();
                password = user.getPassword();
            }
        }
        if (b==0){
            return null;
        }
        else
            return new SimpleAuthenticationInfo("",password,"");
    }
}
