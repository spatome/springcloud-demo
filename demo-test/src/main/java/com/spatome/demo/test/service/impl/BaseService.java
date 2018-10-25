package com.spatome.demo.test.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.core.exception.SException;
import com.spatome.demo.test.factory.DaoFactory;
import com.spatome.demo.test.factory.ServiceFactory;

public abstract class BaseService {

	protected final static Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

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