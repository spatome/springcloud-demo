package com.spatome.demo.oauth.dao;

import java.util.List;

import com.spatome.demo.core.dao.Mapper;
import com.spatome.demo.core.entity.SysUser;

public interface SysUserMapper extends Mapper<SysUser> {

	List<SysUser> selectByBean(SysUser record);
	SysUser selectByUserNo(String userNo);

}