package com.hq.controller;


import com.hq.pojo.User;
import com.hq.service.Impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping({"/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/tologin")
    public String toLoging() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        //获取用户数据
        Subject currentUser = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //执行登录发方法
        try {
            currentUser.login(token);//执行登录操作
            return "index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg", "密码错误");
            return "login";

        }

    }

    // 未授权用户
    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized() {
        return "未授权";
    }

    @RequestMapping("/logout")
    public String loginout(Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg", "注销成功");
        return "index";
    }

    @RequestMapping("/alluser")
    public String getAlluser(Model model) {
        List<User> userList = userService.queryList();
        model.addAttribute("userList", userList);
        return "user/listuser";
    }

}
