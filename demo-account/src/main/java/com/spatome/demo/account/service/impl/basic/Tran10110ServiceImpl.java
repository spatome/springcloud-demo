//package com.spatome.demo.account.service.impl.basic;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//
//import com.spatome.demo.account.service.TranService;
//import com.spatome.demo.account.service.impl.BaseService;
//import com.spatome.demo.core.BaseVO;
//import com.spatome.demo.core.entity.Account;
//import com.spatome.demo.core.vo.SSVO;
//
///** 
// * @Description: account
// * 软删除
// */
//@Service
//public class Tran10110ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	public Object execute(Map<String, String> request, HttpServletResponse response) {
//		BaseVO<SSVO> result = new BaseVO<SSVO>();
//
//		LOGGER.debug("获取参数");
//		String accountNo = request.get("accountNo");
//		String status = request.get("status");
//		LOGGER.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("accountNo", accountNo);
//		paramMap.put("status", status);
//		super.checkNotEmpty(paramMap);
//
//		LOGGER.debug("===========================业务处理=========================");
//		Account record = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
//		if(record==null){
//			result.setCodeMessage("9999", "账号不存在");
//			return result;
//		}
//
//		if("ON".equals(status)){
//		}else if("OFF".equals(status)){
//		}else{
//			result.setCodeMessage("9999", "status不存在");
//			return result;
//		}
//
//		Account accountUpdate = new Account();
//		accountUpdate.setId(record.getId());
//		accountUpdate.setStatus(status);
//		daoFactory.getAccountMapper().updateByPrimaryKeySelective(accountUpdate);
//
//		return result;
//	}
//}
