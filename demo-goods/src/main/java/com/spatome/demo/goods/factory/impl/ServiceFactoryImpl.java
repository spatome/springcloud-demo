package com.spatome.demo.goods.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.goods.controller.client.AccountClient;
import com.spatome.demo.goods.controller.client.UserClient;
import com.spatome.demo.goods.factory.ServiceFactory;
import com.spatome.demo.goods.service.GoodsService;

@Lazy
@Service
public class ServiceFactoryImpl implements ServiceFactory
{
	@Autowired
	private AccountClient accountClient;
	@Autowired
	private UserClient userClient;

	@Autowired
	private GoodsService goodsServiceImpl;
	
	@Override
	public AccountClient getAccountClient() {
		return accountClient;
	}

	@Override
	public UserClient getUserClient() {
		return userClient;
	}

	@Override
	public GoodsService getGoodsService() {
		return goodsServiceImpl;
	}

}
