package com.hq.controller;

import com.hq.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService service;

    @RequestMapping("/hello")
    public  String hello(){
        service.hello();
        return "hello";
    }

}
