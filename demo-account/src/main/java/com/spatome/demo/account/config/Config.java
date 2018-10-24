package com.spatome.demo.account.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("account")
public class Config {

	private String userName;
	private String sex;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
