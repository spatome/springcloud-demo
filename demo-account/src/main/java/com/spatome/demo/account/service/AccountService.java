package com.spatome.demo.account.service;

import java.math.BigDecimal;

public interface AccountService {

	public BigDecimal addAmount(String accountNo, BigDecimal amount);
	public BigDecimal subAmount(String accountNo, BigDecimal amount);

}
