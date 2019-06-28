package com.atguigu.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.springboot.bean.TAdmin;
import com.atguigu.springboot.mapper.TAdminMapper;
import com.atguigu.springboot.service.TAdminService;

@Service
//@Transactional(readOnly=true)
public class TAdminServiceImpl implements TAdminService {

	@Autowired
	private TAdminMapper adminMapper ;

	@Transactional(readOnly=true)
	@Override
	public TAdmin getTAdminById(Integer id) {
		return adminMapper.getTAdminById(id);
	}
}
