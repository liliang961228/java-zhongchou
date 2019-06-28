package com.atguigu.springcloud.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.bean.Movie;
import com.atguigu.springcloud.dao.MovieDao;

@Service
public class MovieService {

	@Autowired
	private MovieDao movieDao;
	
	@Value("${server.port}")
	private String port;
	 
	
	public Movie getNewMovie(){
		System.out.println("当前电影服务的端口："+port);
		return movieDao.getNewMovie();
		} 

	
}
