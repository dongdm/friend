package com.dong.friend.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.servlet.KaptchaExtend;

@Controller
public class RegisterKaptchaController extends KaptchaExtend{
	
	
	
	@RequestMapping(value = "/captcha.jpg", method = RequestMethod.GET)
	public void captcha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.captcha(req, resp);
	} 
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPost(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, 
			HttpServletRequest request){
		ModelAndView model = new ModelAndView("regiser-post");
		if(email.isEmpty()){
			throw new RuntimeException("exail empty");
		}
		if(password.isEmpty()){
			throw new RuntimeException("empty password");
		}
		String captcha = request.getParameter("captcha");
		if(!captcha.equals(getGeneratedKey(request))){
			throw new RuntimeException("bad captcha");
		}
		/*
		 * everything is ok. proceed with your user rigistration / login process.
		 */
		
		return model;
	}

}
