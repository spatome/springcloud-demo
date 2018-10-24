package com.spatome.demo.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spatome.demo.account.factory.DaoFactory;
import com.spatome.demo.account.factory.ServiceFactory;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.exception.SException;

@ControllerAdvice
public class BaseController
{
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected ServiceFactory serviceFactory;

	@Autowired
	protected DaoFactory daoFactory;

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handlerException(Exception ex)
	{
		LOGGER.error("service未知异常:", ex);
		return new BaseVO<Object>("9999", "内部繁忙，请稍后重试");

	}

	@ExceptionHandler(SException.class)
	@ResponseBody
	public BaseVO<Object> sException(SException ex)
	{
		LOGGER.error("service自定义异常:", ex);
		return new BaseVO<Object>(ex.getCode(), ex.getMessage());
	}
}