package com.spatome.demo.account.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.spatome.demo.account.service.AccountService;
import com.spatome.demo.core.entity.Account;
import com.spatome.demo.core.exception.SException;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

	@Override
	public BigDecimal addAmount(String accountNo, BigDecimal amount) {
		if(amount.compareTo(new BigDecimal("5"))==0){
			LOGGER.error("加钱5元异常:"+accountNo);
			throw new SException("9999", "加钱5元异常");
		}

		Account account = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
		BigDecimal newCurrentAmount = account.getCurrentAmount().add(amount);

		Account accountUpdate = new Account();
		accountUpdate.setId(account.getId());
		accountUpdate.setCurrentAmount(newCurrentAmount);
		daoFactory.getAccountMapper().updateByPrimaryKeySelective(accountUpdate);

		return newCurrentAmount;
	}

	@Override
	public BigDecimal subAmount(String accountNo, BigDecimal amount) {
		if(amount.compareTo(new BigDecimal("5"))==0){
			LOGGER.error("扣款5元异常:"+accountNo);
			throw new SException("9999", "扣款5元异常");
		}

		Account account = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
		BigDecimal newCurrentAmount = account.getCurrentAmount().subtract(amount);
		if(newCurrentAmount.signum()==-1){
			LOGGER.error("扣款时余额不足:"+accountNo);
			throw new SException("9999", "扣款时余额不足");
		}

		Account accountUpdate = new Account();
		accountUpdate.setId(account.getId());
		accountUpdate.setCurrentAmount(newCurrentAmount);
		daoFactory.getAccountMapper().updateByPrimaryKeySelective(accountUpdate);

		return newCurrentAmount;
	}

}
