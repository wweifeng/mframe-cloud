package com.mspringcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mspringcloud.consumer.dto.User;
import com.mspringcloud.consumer.service.UserFeignService;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private UserFeignService userFeignService;
	
	@GetMapping("user/{id}")
	public User findById(@PathVariable Long id) {
		//return restTemplate.getForObject("http://provider-user/"+id, User.class);
		System.out.println("this is consumer");
		return userFeignService.findById(id);
	}
	
	@GetMapping("log")
	public void logUserInstance() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("provider-user");
		System.out.println(serviceInstance.getServiceId()+","+serviceInstance.getHost()+","+serviceInstance.getPort());
	}
	

}
