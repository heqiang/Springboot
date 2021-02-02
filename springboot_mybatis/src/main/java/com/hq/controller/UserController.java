package com.hq.controller;

import com.hq.mapper.UserMapper;
import com.hq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/allUser")
    public List<User> queryList() {
        List<User> userList = userMapper.queryList();

        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @RequestMapping("/user")
    public User queryUserById() {
        User user = userMapper.queryById(1);
        return user;
    }
}
