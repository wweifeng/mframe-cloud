package com.mspringcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mspringcloud.consumer.dto.User;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("user/{id}")
	public User findById(@PathVariable Long id) {
		return restTemplate.getForObject("http://127.0.0.1:8081/"+id, User.class);
	}

}
