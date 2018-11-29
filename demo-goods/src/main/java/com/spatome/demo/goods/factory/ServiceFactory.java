package com.spatome.demo.goods.factory;

import com.spatome.demo.goods.controller.client.AccountClient;
import com.spatome.demo.goods.controller.client.UserClient;
import com.spatome.demo.goods.service.GoodsService;

public interface ServiceFactory
{
	public AccountClient getAccountClient();
	public UserClient getUserClient();

	public GoodsService getGoodsService();
}
