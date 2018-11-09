package com.spatome.demo.test.factory;

import com.spatome.demo.test.controller.client.AccountClient;
import com.spatome.demo.test.controller.client.UserClient;

public interface ServiceFactory
{
	public AccountClient getAccountClient();
	public UserClient getUserClient();
}
