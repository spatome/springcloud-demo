package com.spatome.demo.user.dao;

import java.util.List;

import com.spatome.demo.core.dao.Mapper;
import com.spatome.demo.core.entity.Enterprise;

public interface EnterpriseMapper extends Mapper<Enterprise> {

	List<Enterprise> selectByBean(Enterprise record);
	void batchInsert(List<Enterprise> recordList);
	Enterprise selectByEnterpriseNo(String enterpriseNo);

}