package com.spatome.demo.user.factory;

import com.spatome.demo.user.dao.EnterpriseMapper;

public interface DaoFactory
{
	public EnterpriseMapper getEnterpriseMapper();
}
