package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springboot.bean.TAdmin;
import com.atguigu.springboot.service.TAdminService;

@RestController
public class TAdminController {

	@Autowired
	private TAdminService  adminService ;
	
	@ResponseBody
	@RequestMapping("/getTAdminById")
	public TAdmin getTAdminById(Integer id) {
		return adminService.getTAdminById(id); // json串
	}
	
}
