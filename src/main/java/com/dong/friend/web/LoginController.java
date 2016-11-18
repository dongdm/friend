package com.dong.friend.web;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dong.friend.bean.Account;

@Controller
public class LoginController {

	/**
	 * Go login.jsp
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(@ModelAttribute Account account) {
		return "login";
	}
	
	/**
	 * Go login
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(@Valid Account account,BindingResult results, RedirectAttributes rediect) {
		if(results.hasErrors()){
			return new ModelAndView("login","formErrors",results.getAllErrors());
		}
		String loginName = account.getLoginName();
		String password = account.getLoginPwd();
		
		UsernamePasswordToken upt = new UsernamePasswordToken(loginName, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(upt);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			ObjectError err = new ObjectError("validError", "您的账号或密码输入错误!");
			results.addError(err);
			rediect.addFlashAttribute("formErrors", results);
			return new ModelAndView("login","formErrors",results.getAllErrors());
		}
		return new ModelAndView("redirect:/index");
	}
	
	/**
	 * Exit
	 * @return
	 */
	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/index";
	}
}
