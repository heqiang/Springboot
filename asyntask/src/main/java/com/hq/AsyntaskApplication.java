package com.hq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启异步注解功能
@EnableAsync
//开启定时功能注解
@EnableScheduling
@SpringBootApplication
public class AsyntaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyntaskApplication.class, args);
    }

}
