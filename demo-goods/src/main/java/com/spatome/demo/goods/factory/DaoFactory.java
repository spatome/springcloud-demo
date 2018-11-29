package com.spatome.demo.goods.factory;

import com.spatome.demo.goods.dao.PrizeMapper;

public interface DaoFactory
{
	public PrizeMapper getPrizeMapper();
}
