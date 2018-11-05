package com.spatome.demo.test.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.test.dao.AccountMapper;
import com.spatome.demo.test.dao.EnterpriseMapper;
import com.spatome.demo.test.dao.SysPermissionMapper;
import com.spatome.demo.test.dao.SysRoleMapper;
import com.spatome.demo.test.dao.SysUserMapper;
import com.spatome.demo.test.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private EnterpriseMapper enterpriseMapper;
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public EnterpriseMapper getEnterpriseMapper() {
		return enterpriseMapper;
	}

	@Override
	public SysPermissionMapper getSysPermissionMapper() {
		return sysPermissionMapper;
	}

	@Override
	public SysRoleMapper getSysRoleMapper() {
		return sysRoleMapper;
	}

	@Override
	public SysUserMapper getSysUserMapper() {
		return sysUserMapper;
	}

	@Override
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

}