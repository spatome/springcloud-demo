package com.spatome.demo.test.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.test.controller.client.AccountClient;
import com.spatome.demo.test.controller.client.UserClient;
import com.spatome.demo.test.factory.ServiceFactory;

@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory
{
	@Autowired
	private AccountClient accountClient;
	@Autowired
	private UserClient userClient;

	@Override
	public AccountClient getAccountClient() {
		return accountClient;
	}

	@Override
	public UserClient getUserClient() {
		return userClient;
	}

}
