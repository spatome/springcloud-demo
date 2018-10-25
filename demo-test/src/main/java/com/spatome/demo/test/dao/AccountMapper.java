package com.spatome.demo.test.dao;

import java.util.List;

import com.spatome.demo.core.dao.Mapper;
import com.spatome.demo.core.entity.Account;

public interface AccountMapper extends Mapper<Account> {

	List<Account> selectByBean(Account record);
	Account selectByAccountNo(String enterpriseNo);

}