package com.atguigu.springcloud.service.exphandler;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.bean.Movie;
import com.atguigu.springcloud.service.MovieServiceFeign;

@Component
public class MovieServiceFeignExpHandler implements MovieServiceFeign{

	@Override
	public Movie getNameMovie() {
		
		Movie movie = new Movie();
		movie.setId(1111);
		movie.setMovieName("hahahhah");
		
		return movie;
	}

}
