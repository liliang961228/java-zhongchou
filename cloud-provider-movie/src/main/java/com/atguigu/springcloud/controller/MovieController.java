package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.MovieService.MovieService;
import com.atguigu.springcloud.bean.Movie;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movie")
	public Movie getNameMovie() {
		
		return movieService.getNewMovie();
	}
}
