package com.spatome.demo.oauth.factory;

import com.spatome.demo.oauth.service.UserService;

public interface ServiceFactory
{

	public UserService getUserService();

}
