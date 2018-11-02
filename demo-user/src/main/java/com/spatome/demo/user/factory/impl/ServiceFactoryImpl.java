package com.spatome.demo.user.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.user.factory.ServiceFactory;
import com.spatome.demo.user.service.EnterpriseService;

@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory
{
	@Autowired
	private EnterpriseService enterpriseServiceImpl;

	@Override
	public EnterpriseService getEnterpriseService() {
		return enterpriseServiceImpl;
	}

}
