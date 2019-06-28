package com.liliang.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.liliang.springboot.mapper") //扫描Mapper接口，生成代理对象
@ComponentScan("com.liliang.springboot") //扫描组件包，省略不写，默认扫主程序所在的包以及子包
@SpringBootApplication
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}

}
