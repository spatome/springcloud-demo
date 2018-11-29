package com.spatome.demo.goods.dao;

import java.util.List;

import com.spatome.demo.core.dao.Mapper;
import com.spatome.demo.core.entity.Prize;

public interface PrizeMapper extends Mapper<Prize> {

	List<Prize> selectByBean(Prize prizeQ);

}