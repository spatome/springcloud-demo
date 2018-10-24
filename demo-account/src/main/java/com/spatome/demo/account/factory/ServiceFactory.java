package com.spatome.demo.account.factory;

import com.spatome.demo.account.service.AccountService;

public interface ServiceFactory
{
	public AccountService getAccountService();
}
