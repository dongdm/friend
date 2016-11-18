package com.dong.friend.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 发送邮件时，出现握手失败错误，这是由于验证机制不一样
 * 替换jdk/lib/security中的local_policy.jar 和  US_export_policy.jar 
 * 该问题得到解决
 * @author dong
 *
 */
@Component
public class EmailSender {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmailSender.class);
	private String defaultFrom = "691212271@qq.com";
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sender(String to, String subject, String content){
		return sender(to, subject, content, true);
	}
	
	public boolean sender(String to, String subject, String content, boolean html){
		if(StringUtils.isBlank(to)){
			LOG.error("邮件发送失败：收件人地址不能为空。");
			return false;
		}
		return sender(new String[]{to}, subject, content, html);
	}
	
	public boolean sender(String[] to, String subject, String content, boolean html){
		if(to == null || to.length == 0){
			LOG.error("邮件批量发送失败：收件人地址不能为空。");
			return false;
		}
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(defaultFrom);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		javaMailSender.send(simpleMailMessage);
		return true;
	}
}
