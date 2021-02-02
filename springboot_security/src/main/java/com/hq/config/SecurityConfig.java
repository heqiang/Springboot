package com.hq.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人都可以访问,功能也只能有权限的人访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index1/**").hasRole("vip1")
                .antMatchers("/index2/**").hasRole("vip2")
                .antMatchers("/index3/**").hasRole("vip3");
        //没有权限默认会到登录页
        http.formLogin().loginPage("/tologin")
                .loginProcessingUrl("/login")//表单路由
                .failureForwardUrl("/loginerror")
                .defaultSuccessUrl("/index");
        http.csrf().disable();//关闭csrf跨域
        //注销 跳到首页
        http.logout().logoutUrl("/");//注销之后的路由 这里设置为首页

        //开启记住我功能 cookie默认保存两周 自定义接受前端的参数  remember为前端input按钮的name
        http.rememberMe().rememberMeParameter("remember");

    }

    //认证  springboot2.1.xx 可以直接使用
    // 通过 and 无限添加用户
    // 密码编码：passwordEncoder
    // 在spring Secutiry 5.0+ 新增了很多的加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("hq").password(new BCryptPasswordEncoder().encode("111")).roles("vip1", "vip2")
                .and()
                .withUser("hq1").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3");
    }
}

