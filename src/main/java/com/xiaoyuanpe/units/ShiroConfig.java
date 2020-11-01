package com.xiaoyuanpe.units;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器
        /**常用过滤器
         * anon:无需认证可以访问
         * authc：必须经过认证访问
         * user: 如果使用了rememberMe的功能可以直接访问
         * prems:该资源必须授予资源权限才可以访问
         * role：必须得到角色授权才可以访问 **/
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/login/**", "anon");
        map.put("/**", "authc");
        map.put("/**", "perms[]");
        shiroFilterFactoryBean.setLoginUrl("/login/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setSessionManager(sessionManager());
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    @Bean(name = "realm")
    public Realm getRealm(){
        Realm realm = new Realm();
        //开启缓存管理EhCache
//        realm.setCachingEnabled(true);//开启全局缓存
//        realm.setAuthenticationCachingEnabled(true);//开启认证缓存
//        realm.setAuthenticationCacheName("authenticationCache");
//        realm.setAuthorizationCachingEnabled(true);//开启授权缓存
//        realm.setAuthorizationCacheName("authorizationCache");
        return new Realm();
    }
//
//    @Bean(name = "sessionManager")
//    public DefaultWebSessionManager sessionManager() {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        // 设置session过期时间3600s
//        sessionManager.setDeleteInvalidSessions(true);
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setGlobalSessionTimeout(24*60*60*1000L);
//        return sessionManager;
//    }
}
