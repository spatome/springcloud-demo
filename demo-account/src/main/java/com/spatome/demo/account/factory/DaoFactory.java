package com.spatome.demo.account.factory;

import com.spatome.demo.account.dao.AccountMapper;
import com.spatome.demo.account.dao.EnterpriseMapper;

public interface DaoFactory
{
	public AccountMapper getAccountMapper();
	public EnterpriseMapper getEnterpriseMapper();
}
