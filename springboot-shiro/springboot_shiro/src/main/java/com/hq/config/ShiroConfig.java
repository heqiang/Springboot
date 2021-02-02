package com.hq.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //3 shirofactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultSecurityManager") DefaultSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /*
         * anon :无需认证就可以访问
         * authc:必须认证了才能访问
         * user:必须拥有 记住我 才能用
         * perms:拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         * */
        Map<String, String> map = new HashMap<>();
        //访问路径可以使用通配符
        //未授权的用户访问 跳到未授权页面
        map.put("/user/add", "perms[user:add]");
        map.put("/user/update", "perms[user:update]");
        map.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(map);

        //设置登录的路由请求
        bean.setLoginUrl("/tologin");
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    // 2 DefaultWebSecurityManager
    @Bean
    public DefaultSecurityManager defaultSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //1 创建realm对象 需要自定义
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
