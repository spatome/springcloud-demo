package com.spatome.demo.oauth.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.oauth.factory.ServiceFactory;
import com.spatome.demo.oauth.service.UserService;

@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory
{
	@Autowired
	private UserService userServiceImpl;

	@Override
	public UserService getUserService() {
		return userServiceImpl;
	}
	
}
