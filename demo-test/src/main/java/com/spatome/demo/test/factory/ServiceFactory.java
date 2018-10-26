package com.spatome.demo.test.factory;

import com.spatome.demo.test.controller.client.AccountClient;

public interface ServiceFactory
{
	public AccountClient getAccountClient();
}
