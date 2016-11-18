package com.dong.friend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dong.friend.bean.Account;
import com.dong.friend.bean.Message;
import com.dong.friend.service.MessageRepository;

@Controller
public class IndexController {
	
	@Autowired
	private  MessageRepository messageRepository;

	/**
	 * Go Index
	 * @return
	 */
	@RequestMapping(value={"", "/", "index"})
	public ModelAndView index() {
		Iterable<Message> messages = this.messageRepository.findAll();
		return new ModelAndView("messages/list", "messages", messages);
	}
	
	/**
	 * unauthor
	 * @return
	 */
	@RequestMapping("unauthor")
	public String unauthor(@ModelAttribute Account account) {
		return "login";
	}
	
	/**
	 * reports
	 * @return
	 */
	@RequestMapping("reports")
	public String reports() {
		return "users/list";
	}
}
