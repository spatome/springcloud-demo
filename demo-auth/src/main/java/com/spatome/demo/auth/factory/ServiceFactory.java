package com.spatome.demo.auth.factory;

import com.spatome.demo.auth.service.UserService;

public interface ServiceFactory
{

	public UserService getUserService();

}
