/*package com.mspringcloud.provider.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	*//**
	 * 模拟两个账户
	 * 1、账号是 user , 密码是123456, 角色是user-role
	 * 2、账号是admin, 密码是123456, 角色是amdin-role
	 *//*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("user".equals(username)) {
			return new SecurityUser("user","123456","user-role");
		} 
	    
	    if("admin".equals(username)) {
			return new SecurityUser("admin","123456","amdin-role");
		}
			
	    return null;
	}

}
*/