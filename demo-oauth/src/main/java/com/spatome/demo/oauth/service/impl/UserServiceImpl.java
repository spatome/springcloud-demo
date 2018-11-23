package com.spatome.demo.oauth.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.oauth.service.UserService;
import com.spatome.demo.oauth.vo.UserVO;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.SysUser;
import com.spatome.demo.core.util.SUtil;
import com.spatome.demo.core.util.security.JwtUtil;

@Service
//@Slf4j
public class UserServiceImpl extends BaseService implements UserService {

	@Override
	@Transactional
	public BaseVO<?> userLogin(HttpServletRequest request, HttpServletResponse response) {
		BaseVO<UserVO> result = new BaseVO<UserVO>();
		UserVO VO = new UserVO();
		result.setBody(VO);

		//参数 
		String userNo = request.getParameter("userNo");
		String password = request.getParameter("password");
		//校验参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userNo", userNo);
		paramMap.put("password", password);
		super.checkNotEmpty(paramMap);

		//业务处理
		SysUser record = daoFactory.getSysUserMapper().selectByUserNo(userNo);
		if(record==null){
			result.setCodeMessage("9999", "用户不存在");
			return result;
		}
		if(!password.equals(record.getUserPwd())){
			result.setCodeMessage("9999", "用户密码错误");
			return result;
		}

		VO.setUserNo(record.getUserNo());
		VO.setUserName(record.getUserName());
		VO.setNickName(record.getNickName());
		VO.setUserRole(SUtil.NTS(record.getSysRoleId()));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("role", SUtil.NTS(record.getSysRoleId()));
		String token = JwtUtil.buildJwt(userNo, map, 0l);
		VO.setToken(token);

		return result;
	}
}
