package com.spatome.demo.test.factory;

import com.spatome.demo.test.dao.AccountMapper;
import com.spatome.demo.test.dao.EnterpriseMapper;
import com.spatome.demo.test.dao.SysPermissionMapper;
import com.spatome.demo.test.dao.SysRoleMapper;
import com.spatome.demo.test.dao.SysUserMapper;

public interface DaoFactory
{
	public AccountMapper getAccountMapper();
	public EnterpriseMapper getEnterpriseMapper();
	public SysPermissionMapper getSysPermissionMapper();
	public SysRoleMapper getSysRoleMapper();
	public SysUserMapper getSysUserMapper();
}
