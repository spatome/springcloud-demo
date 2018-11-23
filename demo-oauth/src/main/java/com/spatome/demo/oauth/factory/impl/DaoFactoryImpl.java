package com.spatome.demo.oauth.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.oauth.dao.SysPermissionMapper;
import com.spatome.demo.oauth.dao.SysRoleMapper;
import com.spatome.demo.oauth.dao.SysUserMapper;
import com.spatome.demo.oauth.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysUserMapper sysUserMapper;

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

}