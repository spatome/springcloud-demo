package com.spatome.demo.goods.service;

public interface GoodsService {

	public int addPrizeBalanceCount(long prizeId, int count, String sleep);
	public int subPrizeBalanceCount(long prizeId, int count, String sleep);

}
