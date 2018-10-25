package com.spatome.demo.test.dao;

import java.util.List;

import com.spatome.demo.core.dao.Mapper;
import com.spatome.demo.core.entity.Enterprise;

public interface EnterpriseMapper extends Mapper<Enterprise> {

	List<Enterprise> selectByBean(Enterprise record);
	Enterprise selectByEnterpriseNo(String enterpriseNo);

}