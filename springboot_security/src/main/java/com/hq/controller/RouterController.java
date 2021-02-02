package com.hq.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (username.equals("anonymousUser")) {
            model.addAttribute("username", "游客");
        } else {
            model.addAttribute("username", username);
        }
        System.out.println(username);
        return "index";
    }

    @RequestMapping("/index1")
    public String index1() {
        return "index1";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }

    @RequestMapping("/index3")
    public String index3() {
        return "index3";
    }

    @RequestMapping("/tologin")
    public String tologin() {
        return "login";
    }

    @RequestMapping("/loginerror")
    public String loginError() {
        return "loginerror";
    }

}
