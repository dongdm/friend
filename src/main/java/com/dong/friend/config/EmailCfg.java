package com.dong.friend.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Configuration
public class EmailCfg {
	
	@Bean
	public JavaMailSender javaMailSender(){
		JavaMailSenderImpl sender = new JavaMailSenderImpl();

        sender.setHost("smtp.qq.com");
        sender.setPort(465);
        sender.setUsername("691212271@qq.com");
        sender.setPassword("nztywdudvcybbeeh"); // 这里要用邀请码，不是你登录邮箱的密码

        Properties pro = System.getProperties(); // 下面各项缺一不可
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.ssl.enable", "true");
        pro.put("mail.smtp.timeout", "25000");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        sender.setJavaMailProperties(pro);
        return sender;
	}
	

}
