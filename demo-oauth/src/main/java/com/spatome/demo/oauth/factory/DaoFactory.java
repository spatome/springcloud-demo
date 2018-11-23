package com.spatome.demo.oauth.factory;

import com.spatome.demo.oauth.dao.SysPermissionMapper;
import com.spatome.demo.oauth.dao.SysRoleMapper;
import com.spatome.demo.oauth.dao.SysUserMapper;

public interface DaoFactory
{
	public SysPermissionMapper getSysPermissionMapper();
	public SysRoleMapper getSysRoleMapper();
	public SysUserMapper getSysUserMapper();
}
