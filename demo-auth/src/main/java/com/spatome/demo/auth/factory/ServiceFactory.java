package com.spatome.demo.auth.factory;

import com.spatome.demo.auth.service.AuthService;

public interface ServiceFactory
{

	public AuthService getUserService();

}
