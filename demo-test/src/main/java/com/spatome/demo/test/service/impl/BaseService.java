package com.spatome.demo.test.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spatome.demo.core.exception.SException;

public abstract class BaseService {

	protected final static Logger LOGGER = LoggerFactory.getLogger(BaseService.class);
	
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