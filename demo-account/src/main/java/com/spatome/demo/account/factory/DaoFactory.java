package com.spatome.demo.account.factory;

import com.spatome.demo.account.dao.AccountMapper;
import com.spatome.demo.account.dao.EnterpriseMapper;
import com.spatome.demo.account.dao.SysPermissionMapper;
import com.spatome.demo.account.dao.SysRoleMapper;
import com.spatome.demo.account.dao.SysUserMapper;

public interface DaoFactory
{
	public AccountMapper getAccountMapper();
	public EnterpriseMapper getEnterpriseMapper();
	public SysPermissionMapper getSysPermissionMapper();
	public SysRoleMapper getSysRoleMapper();
	public SysUserMapper getSysUserMapper();
}
