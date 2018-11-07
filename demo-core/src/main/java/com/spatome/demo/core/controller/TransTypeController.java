package com.spatome.demo.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.demo.core.service.TranService;
import com.spatome.demo.core.util.spring.SpringUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/process")
@Slf4j
public class TransTypeController extends BController {

	@RequestMapping(value = "{transType}", method = RequestMethod.POST)
	public Object process(
			@PathVariable String transType,
			@RequestParam Map<String, String> inMap,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		log.debug("==>"+inMap);

		Object result = null;
		try
		{
			Object bean = SpringUtil.getApplicationContext().getBean("tran"+transType+"ServiceImpl");
			result = ((TranService)bean).execute(inMap, request, response);
		}
		catch (Exception e)
		{
			log.error("==>transType{{}}inMap{{}}", transType, inMap);
			throw e;
		}

		return result;
	}

}
