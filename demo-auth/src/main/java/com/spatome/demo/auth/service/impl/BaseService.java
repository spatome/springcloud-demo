package com.spatome.demo.auth.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.auth.factory.DaoFactory;
import com.spatome.demo.auth.factory.ServiceFactory;
import com.spatome.demo.core.exception.SException;

public abstract class BaseService {

	@Autowired
	protected DaoFactory daoFactory;
	@Autowired
	protected ServiceFactory serviceFactory;

	/** 
	 * @Description: 不空检查
	 */
	public void checkNotEmpty(Map<String, String> paramMap){
		for (Map.Entry<String, String> f : paramMap.entrySet()) {
			if(StringUtils.isBlank(f.getValue())){
				throw new SException("9999", f.getKey()+"不能为空！");
			}
		}
	}

}