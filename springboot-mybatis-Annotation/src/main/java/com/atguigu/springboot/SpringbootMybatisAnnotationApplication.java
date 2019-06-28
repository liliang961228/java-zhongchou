package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//扫描mapper接口，生成代理对象
@MapperScan("com.atguigu.springboot.mapper")

@ServletComponentScan//web的组件扫描，扫描@WebServlet @WebFilter @WebListener

@EnableTransactionManagement
@SpringBootApplication
public class SpringbootMybatisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisAnnotationApplication.class, args);
	}

}
