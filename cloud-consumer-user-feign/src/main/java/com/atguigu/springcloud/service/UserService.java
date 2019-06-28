package com.atguigu.springcloud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.bean.Movie;
import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.dao.UserDao;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	MovieServiceFeign movieServiceFeign;

	 
	public User getUserById(Integer id){
	User user = userDao.getUser(id);
	return user;
	}
	 
	/**
	   * 购买最新的电影票
	   * 传入用户id
	   */

	
	public Map<String, Object> buyMovieById(Integer id){
	Map<String, Object>  result = new HashMap<>();
	//1、查询用户信息
	User user = getUserById(id);
	
	Movie movie = movieServiceFeign.getNameMovie();
	//2、查到最新电影票  
	result.put("user", user);
	result.put("movie", movie);
	return result;
	}

}
