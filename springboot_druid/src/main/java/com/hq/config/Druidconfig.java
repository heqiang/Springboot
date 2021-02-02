package com.hq.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class Druidconfig {
    //    与我们的yml 连接起来
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //    后台监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        设置密码
        HashMap<String, String> map = new HashMap<>();
//        添加配置  登录的账号和密码是固定的
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
//        设置允许谁访问
        map.put("allow", "");
//        也可以设置禁止谁访问
//        设置初始化参数
        bean.setInitParameters(map);
        return bean;
    }

    //    过滤器
    @Bean
    public FilterRegistrationBean webdilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
//        可以过滤那些请求
        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        添加就可以了
//        那些不过滤
        stringStringHashMap.put("exclusions", "*.js,*.css,/druid/*");
//        初始化参数
        bean.setInitParameters(stringStringHashMap);
        return bean;

    }
}