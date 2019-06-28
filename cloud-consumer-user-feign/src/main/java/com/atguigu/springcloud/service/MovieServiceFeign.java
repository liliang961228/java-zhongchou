package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.atguigu.springcloud.bean.Movie;
import com.atguigu.springcloud.service.exphandler.MovieServiceFeignExpHandler;

/**
 * Feign接口用于调用远程服务
 * @author liliang
 *
 */

//@FeignClient(value="CLOUD-PROVIDER-MOVIE")//要与在注册中心的名称一致
@FeignClient(value="CLOUD-PROVIDER-MOVIE",fallback=MovieServiceFeignExpHandler.class)
public interface MovieServiceFeign {
	
	@GetMapping("/movie")
	public Movie getNameMovie();//与被调用服务端的映射方法一致 

}
