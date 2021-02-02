package com.hq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class AsyntaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件发送
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("这是测试邮件主题");
        simpleMailMessage.setText("Thanks Ks");
        simpleMailMessage.setTo("1418856457@qq.com");
        simpleMailMessage.setFrom("1422127065@qq.com");

        mailSender.send(simpleMailMessage);
    }

}
