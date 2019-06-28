 package com.atguigu.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.bean.Movie;
import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	 
	@GetMapping("/user")
	public User getUser(@RequestParam("id")Integer id){
	User user = userService.getUserById(id);
	return user;
	}
	
	//@HystrixCommand(fallbackMethod="hystrix")
	@HystrixCommand(fallbackMethod="buyMovieError")
	@GetMapping("/buyMovie")
	public Map<String, Object> buyMovie(@RequestParam("id")Integer userid){
	Map<String, Object> map = userService.buyMovieById(userid);
	return map;
	}
	
	
	public Map<String, Object> buyMovieError(@RequestParam("id")Integer userid){
		HashMap<String,Object> hashMap = new HashMap();
		
		User user = userService.getUserById(userid);
		Movie movie = new Movie();
		movie.setId(-1);
		movie.setMovieName("没有电影");
		hashMap.put("user", user);
		hashMap.put("movie", movie);
		return hashMap;
	}

}
