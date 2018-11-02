//package com.spatome.demo.auth.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
///*
//[/oauth/authorize]	验证
//[/oauth/token]		获取token
//[/oauth/check_token]
//[/oauth/confirm_access]	用户授权
//[/oauth/token_key]	资源服务器用来校验token
//[/oauth/error]	认证失败
///oauth/token_key：如果jwt模式则可以用此来从认证服务器获取公钥
//*/
//@Configuration
//@EnableAuthorizationServer
//public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    /*用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)*/
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//    	endpoints.authenticationManager(authenticationManager())
//    	.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
//    }
//
//	/*配置客户端详情信息*/
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//    	clients.inMemory()
//   	 	.withClient("web")
//	 	.secret(passwordEncoder().encode("web"))
//   	 	.authorizedGrantTypes("password", "authorization_code", "refresh_token")
//   	 	.scopes("all");
//	}
//
//    /*用来配置令牌端点(Token Endpoint)的安全约束*/
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
//    	//允许表单认证
//    	oauthServer.allowFormAuthenticationForClients();
//    	//允许check_token访问
//    	oauthServer.checkTokenAccess("permitAll()");
//    }
//
//    /*对称加密*/
///*    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("123");
//        return converter;
//    }*/
//
//    public AuthenticationManager authenticationManager() {
//    	AuthenticationManager authenticationManager = new AuthenticationManager(){
//
//			@Override
//			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//				return daoAuhthenticationProvider().authenticate(authentication);
//			}
//    		
//    	};
//
//		return authenticationManager;
//	}
//
//    @Bean
//    public AuthenticationProvider daoAuhthenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        userDetailsService.createUser(User.withUsername("root").password(passwordEncoder().encode("root")).authorities("ROLE_USER").build());
//        userDetailsService.createUser(User.withUsername("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_USER").build());
//        return userDetailsService;
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        //加密方式
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder;
//    }
//}
