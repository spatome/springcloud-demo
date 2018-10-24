package com.spatome.demo.account.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.account.factory.ServiceFactory;
import com.spatome.demo.account.service.AccountService;

@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory
{
	@Autowired
	private AccountService accountServiceImpl;

	@Override
	public AccountService getAccountService() {
		return accountServiceImpl;
	}

}
