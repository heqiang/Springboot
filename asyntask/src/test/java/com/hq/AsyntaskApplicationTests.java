package com.hq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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

    @Test
    void contextLoads2() throws MessagingException {
        //一个简单的邮件发送
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //正文
        helper.setSubject("哈哈哈哈 测试邮件");
        helper.setText("测试内容");
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\hq\\Desktop\\1.jpg"));
        helper.setTo("1418856457@qq.com");
        helper.setFrom("1422127065@qq.com");

        mailSender.send(mimeMessage);
    }
    
    

}
