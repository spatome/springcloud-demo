package com.spatome.demo.user.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.user.dao.EnterpriseMapper;
import com.spatome.demo.user.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	@Autowired
	private EnterpriseMapper enterpriseMapper;

	@Override
	public EnterpriseMapper getEnterpriseMapper() {
		return enterpriseMapper;
	}

}