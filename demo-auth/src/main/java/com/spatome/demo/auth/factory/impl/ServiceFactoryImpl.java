package com.spatome.demo.auth.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.auth.factory.ServiceFactory;
import com.spatome.demo.auth.service.UserService;

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
