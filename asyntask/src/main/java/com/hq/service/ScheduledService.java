package com.hq.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

//一定要加这个注解
@Configuration
public class ScheduledService {

    //cron表达式
    // 秒 分 时 天 月 周几
    // 0/5 -》每5秒
    // 30 0/5 10,18 * * ？ 每天10点和18点 每隔五分钟执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void  hello(){
        System.out.println("你被执行了");
    }
}
