package com.spatome.demo.goods.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.spatome.demo.goods.dao.PrizeMapper;
import com.spatome.demo.goods.factory.DaoFactory;

@Lazy
@Service
public class DaoFactoryImpl implements DaoFactory
{
	@Autowired
	private PrizeMapper prizeMapper;

	@Override
	public PrizeMapper getPrizeMapper() {
		return prizeMapper;
	}
}