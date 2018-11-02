package com.spatome.demo.user.factory;

import com.spatome.demo.user.service.EnterpriseService;

public interface ServiceFactory
{
	public EnterpriseService getEnterpriseService();
}
