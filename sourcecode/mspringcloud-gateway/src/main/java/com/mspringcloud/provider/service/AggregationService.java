package com.mspringcloud.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mspringcloud.provider.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rx.Observable;

@Service
public class AggregationService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback")
	public Observable<User> getUserById(Long id){
		// 创建一个被观察者
		return Observable.create(observer -> {
			User user = restTemplate.getForObject("http://provider-user/{id}", User.class,id);
			observer.onNext(user);
			observer.onCompleted();
		} );
	}

	@HystrixCommand(fallbackMethod = "fallback")
	public Observable<User> getMovieUserById(Long id){
		// 创建一个被观察者
		return Observable.create(observer -> {
			User user = restTemplate.getForObject("http://consumer-user/user/{id}", User.class,id);
			observer.onNext(user);
			observer.onCompleted();
		} );
	}
	
	public User fallback(Long id) {
		User user = new User();
		user.setId(-1L);
		return user;
	}
	
}
