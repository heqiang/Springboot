package com.hq.service.Impl;

import com.hq.mapper.UserMapper;
import com.hq.pojo.User;
import com.hq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryList() {
        return userMapper.queryList();
    }

    @Override
    public User queryById(int id) {
        return null;
    }

    @Override
    public User queryByName(String username) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }
}
