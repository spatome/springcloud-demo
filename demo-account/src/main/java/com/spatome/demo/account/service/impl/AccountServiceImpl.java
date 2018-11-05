package com.spatome.demo.account.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.spatome.demo.account.service.AccountService;
import com.spatome.demo.core.entity.Account;
import com.spatome.demo.core.exception.SException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl extends BaseService implements AccountService {

	@Override
	public BigDecimal addAmount(String accountNo, BigDecimal amount) {
		if(amount.compareTo(new BigDecimal("5"))==0){
			log.error("==>accountNo{{}}加钱5元异常:", accountNo);
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
			log.error("==>accountNo{{}}扣钱5元异常:", accountNo);
			throw new SException("9999", "扣款5元异常");
		}

		Account account = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
		BigDecimal newCurrentAmount = account.getCurrentAmount().subtract(amount);
		if(newCurrentAmount.signum()==-1){
			log.error("==>扣款时accountNo{{}}余额不足:", accountNo);
			throw new SException("9999", "扣款时余额不足");
		}

		Account accountUpdate = new Account();
		accountUpdate.setId(account.getId());
		accountUpdate.setCurrentAmount(newCurrentAmount);
		daoFactory.getAccountMapper().updateByPrimaryKeySelective(accountUpdate);

		return newCurrentAmount;
	}

}
