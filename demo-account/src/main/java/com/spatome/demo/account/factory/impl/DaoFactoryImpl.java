package com.spatome.demo.account.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.account.dao.AccountMapper;
import com.spatome.demo.account.dao.EnterpriseMapper;
import com.spatome.demo.account.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private EnterpriseMapper enterpriseMapper;

	@Override
	public EnterpriseMapper getEnterpriseMapper() {
		return enterpriseMapper;
	}

	@Override
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

}