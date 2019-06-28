package com.atguigu.springboot.config;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@SpringBootConfiguration
public class DataSourceConfig {
	
	//加载数据配置文件以spring.datasource前缀的数据，并注入ds对象
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DruidDataSource dataSource() throws SQLException {
		DruidDataSource ds = new DruidDataSource();
		System.out.println(ds.getClass());
//		ds.setUsername("root");
//		ds.setPassword(("root");
		ds.setFilters("stat");// 配置监控统计拦截的filters
		return ds;
	}
	
	// 配置Druid的监控
	// 1、配置一个管理后台的Servlet
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		Map<String, String> initParams = new HashMap<>();
		initParams.put("loginUsername", "admin");
		initParams.put("loginPassword", "123456");
		initParams.put("allow", "");// 默认就是允许所有访问
		//initParams.put("deny", "192.168.15.21");// 拒绝哪个ip访问
		bean.setInitParameters(initParams);
		return bean;
	}

	// 2、配置一个web监控的filter
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		Map<String, String> initParams = new HashMap<>();
		initParams.put("exclusions", "*.js,*.css,/druid/*");// 排除过滤
		bean.setInitParameters(initParams);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}

}
