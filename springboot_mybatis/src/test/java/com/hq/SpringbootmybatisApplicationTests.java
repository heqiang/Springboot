package com.hq;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootmybatisApplicationTests {

    @Test
    void contextLoads() {

        MybatisProperties mybatisProperties = new MybatisProperties();
        System.out.println(mybatisProperties.getConfigLocation());
    }

}
