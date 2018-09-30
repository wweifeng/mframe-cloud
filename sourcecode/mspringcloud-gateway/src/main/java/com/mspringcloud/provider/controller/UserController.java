package com.mspringcloud.provider.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.collect.Maps;
import com.mspringcloud.provider.dao.UserRepository;
import com.mspringcloud.provider.dto.User;
import com.mspringcloud.provider.service.AggregationService;

import rx.Observable;
import rx.Observer;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AggregationService aggregationService;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	@GetMapping("/aggregate/{id}")
	public DeferredResult<HashMap<String,User>> aggregate(@PathVariable Long id){
		Observable<HashMap<String,User>> result = aggregateObservable(id);
		return toDeferredResult(result);
	}
	
	public Observable<HashMap<String,User>> aggregateObservable(Long id){
		return Observable.zip(
				aggregationService.getMovieUserById(id), 
				aggregationService.getUserById(id),
				(movieUser,user) -> {
					HashMap<String, User> map = Maps.newHashMap();
					map.put("user", user);
					map.put("movieUser", movieUser);
					return map;
				  }
				);
	}
	
	public DeferredResult<HashMap<String,User>> toDeferredResult(Observable<HashMap<String,User>> details){
		DeferredResult<HashMap<String,User>> result = new DeferredResult<>();
		details.subscribe(new Observer<HashMap<String,User>>() {

			@Override
			public void onCompleted() {
				System.out.println("完成......");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("发生错误......");
			}

			@Override
			public void onNext(HashMap<String, User> t) {
				result.setResult(t);
			}
			
		});
		return result;
	}
}
