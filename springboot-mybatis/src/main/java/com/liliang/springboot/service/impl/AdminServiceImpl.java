package com.liliang.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liliang.springboot.bean.Admin;
import com.liliang.springboot.mapper.AdminMapper;
import com.liliang.springboot.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public Admin getAdminById() {
		Admin adminById = adminMapper.getAdminById();
		System.out.println("================================"+adminById.toString());
		return adminById;
	}

}
