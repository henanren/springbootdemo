package com.laomn.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laomn.common.TenantContextHolder;
import com.laomn.dao.TestMapper;
import com.laomn.entites.Test;

@Service
public class TestService {
	private static int ID = 0;
	@Autowired
	private TestMapper testMapper;

	public Test selectByPrimaryKey(Long id) {
		return testMapper.selectByPrimaryKey(id);
	}

	public int insert() {
		Test test = new Test();
		test.setCreTime(new Date());
		test.setName(TenantContextHolder.getTenant());
		return testMapper.insert(test);
	}

}
