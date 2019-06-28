package com.atguigu.scw.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.scw.user.bean.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="测试Swagger的Helloworld程序")
@RestController
public class SwaggerController {

	
	@ApiImplicitParams(value= {
		@ApiImplicitParam(value="用户姓名",name="name",
				required=true,defaultValue="小黑")	
	})
	@ApiOperation(value="测试SwaggerHello方法")
	@GetMapping("/hello")
	public String hello(String name) {
		return "OK:"+name;
	}

	
	@ApiOperation("测试方法Hello2")
	@ApiImplicitParams(value= {
			@ApiImplicitParam(name="name",value="姓名",required=true),
			@ApiImplicitParam(name="email",value="电子邮件")
	})
	@PostMapping("/user")
	public User user(String name ,String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		return user;
	}

}
