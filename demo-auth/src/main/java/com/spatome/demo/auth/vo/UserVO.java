package com.spatome.demo.auth.vo;

import lombok.Data;

@Data
public class UserVO {

	private String userNo;
	private String userName;
	private String nickName;

	private String userRole;

	private String token;
}
