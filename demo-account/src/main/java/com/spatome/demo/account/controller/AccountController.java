package com.spatome.demo.account.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.vo.SSVO;

@RestController
@RequestMapping(value = "/api/v1")
public class AccountController extends BaseController {
	
	@RequestMapping(value = "addAmount", method = RequestMethod.POST)
	public Object addAmount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<Object> result = new BaseVO<Object>();

		String accountNo = request.getParameter("accountNo");
		String amount = request.getParameter("amount");

		BigDecimal ret = serviceFactory.getAccountService().addAmount(accountNo, new BigDecimal(amount));
		result.setBody(new SSVO(ret.toPlainString()));

		return result;
	}

	@RequestMapping(value = "subAmount", method = RequestMethod.POST)
	public Object subAmount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<Object> result = new BaseVO<Object>();

		String accountNo = request.getParameter("accountNo");
		String amount = request.getParameter("amount");

		BigDecimal ret = serviceFactory.getAccountService().addAmount(accountNo, new BigDecimal(amount));
		result.setBody(new SSVO(ret.toPlainString()));

		return result;
	}
}
