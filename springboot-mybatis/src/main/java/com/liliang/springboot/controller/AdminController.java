package com.liliang.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liliang.springboot.bean.Admin;
import com.liliang.springboot.service.AdminService;


@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping("/getAdminById")
	public String getAdminById() {
		
		return adminService.getAdminById().getLoginacct();
		
		
	}
	
}
