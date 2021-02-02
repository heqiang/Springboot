package com.hq;

import com.hq.pojo.User;
import com.hq.utils.RedisUtile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisApplicationTests {
    @Autowired
    @Qualifier("redisTemplate1")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtile redisUtile;

    @Test
    void contextLoads() {
//       redisTemplate.opsForValue().set("hq","ceshi");
//        System.out.println(redisTemplate.opsForValue().get("hq"));
        User user = new User("hq",11);

        redisUtile.set("user1",user);
        System.out.println(redisUtile.get("user1"));
    }

}
