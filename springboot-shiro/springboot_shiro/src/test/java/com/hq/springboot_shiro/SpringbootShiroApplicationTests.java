package com.hq.springboot_shiro;

import com.hq.mapper.UserMapper;
import com.hq.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        User user = userMapper.queryByName("hq1");
        System.out.println(user);
    }

}
