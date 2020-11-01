package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.Permissions;
import com.xiaoyuanpe.pojo.Role;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.PermissionService;
import com.xiaoyuanpe.services.RoleService;
import com.xiaoyuanpe.services.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class Realm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        String primaryPrincipal = (String)principalCollection.getPrimaryPrincipal();
        System.out.println(primaryPrincipal);
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        List<Role> rolesByUsername = userService.findRolesByUsername(primaryPrincipal).getRoles();
        if (!CollectionUtils.isEmpty(rolesByUsername)){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            rolesByUsername.forEach((role)->{
                System.out.println(role.getRoleName());
                info.addRole(role.getRoleName());
//                List<Permissions> perms = userService.findPermsByRoleId(role.getId());
//                if (!CollectionUtils.isEmpty(perms)){
//                    perms.forEach(perms1 -> {
//                        System.out.println(perms1.getPermissionName());
//                        info.addStringPermission(perms1.getPermissionName());
//                    });
//                }
            });
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String principal = (String) authenticationToken.getPrincipal();
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        User user = userService.findUsersByStudentNum(principal);
        if (!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(principal,user.getPassword(), this.getName());
        }
        return null;
    }
}
