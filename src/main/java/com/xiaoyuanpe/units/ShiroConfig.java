package com.xiaoyuanpe.units;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器
        /**常用过滤器
         * anon:无需认证可以访问
         * authc：必须经过认证访问
         * user: 如果使用了rememberMe的功能可以直接访问
         * prems:该资源必须授予资源权限才可以访问
         * role：必须得到角色授权才可以访问**/
        Map<String,String> map = new LinkedHashMap<>();
//        map.put("/user/**","authc");
        //map.put("/**","authc");
//        shiroFilterFactoryBean.setLoginUrl("/tologin");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

//        //授权过滤器
//        map.put("/add","perms[user:add]");
//        //设置未授权提示页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("");


        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean(name = "realm")
    public Realm getRealm(){
        return new Realm();
    }
}
