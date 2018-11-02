package com.spatome.demo.auth.factory;

import com.spatome.demo.auth.dao.SysPermissionMapper;
import com.spatome.demo.auth.dao.SysRoleMapper;
import com.spatome.demo.auth.dao.SysUserMapper;

public interface DaoFactory
{
	public SysPermissionMapper getSysPermissionMapper();
	public SysRoleMapper getSysRoleMapper();
	public SysUserMapper getSysUserMapper();
}
