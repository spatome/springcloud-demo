package com.spatome.demo.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "my")
public class MyConfig {

	private static String userName;

	public static String getUserName() {
		return userName;
	}

	@Value("userName")
	public void setUserName(String userName) {
		MyConfig.userName = userName;
	}

}
