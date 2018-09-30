package com.mspringcloud.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mspringcloud.provider.dao.UserRepository;
import com.mspringcloud.provider.dto.User;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	/*@GetMapping("/auth/{id}")
	public User auth(@PathVariable Long id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails)principal;
			Collection<? extends GrantedAuthority> collection = userDetails.getAuthorities();
		    for(GrantedAuthority grantedAuthority : collection) {
		    	logger.info("当前用户是{},角色是{}",userDetails.getUsername() , grantedAuthority.getAuthority());
		    }
		}
		User user = userRepository.findOne(id);
		return user;
	}*/
	
}
