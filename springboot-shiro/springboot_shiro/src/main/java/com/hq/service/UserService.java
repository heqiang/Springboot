package com.hq.service;

import com.hq.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> queryList();

    User queryById(@Param("uid") int id);

    User queryByName(@Param("name") String username);

    int addUser(User user);
}
