package com.dong.friend.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class Account {
	
	@NotEmpty(message = "loginName is requied.")
	private String loginName;
	@NotEmpty(message = "loginPwd is requied.")
	private String loginPwd;
	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
	

}
