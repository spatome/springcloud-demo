//package com.spatome.demo.auth.service.impl;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	private final static Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		//daoFactory.get
//		if("admin1".equals(userName)){
//			LOGGER.error("用户名不存在,用户名:"+userName);
//			throw new UsernameNotFoundException("用户名不存在，用户名:"+userName);
//		}
//
//		//获取用户角色和权限
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        boolean enabled = true; 				// 可用性 :true:可用 false:不可用
//        boolean accountNonExpired = true; 		// 过期性 :true:没过期 false:过期
//        boolean credentialsNonExpired = true; 	// 有效性 :true:凭证有效 false:凭证无效
//        boolean accountNonLocked = true; 		// 锁定性 :true:未锁定 false:已锁定
//		if("admin".equals(userName)){
//			grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
//			grantedAuthorities.add(new SimpleGrantedAuthority("finance"));
//		}else {
//			grantedAuthorities.add(new SimpleGrantedAuthority("provider"));
//			grantedAuthorities.add(new SimpleGrantedAuthority("hold"));
//		}
//
//        //User user = new User(userName, userName, grantedAuthorities);
//        User user = new User(
//        	userName,
//        	userName,
//        	enabled,
//        	accountNonExpired,
//        	credentialsNonExpired,
//        	accountNonLocked,
//        	grantedAuthorities);
//
//		return user;
//	}
//
//}
