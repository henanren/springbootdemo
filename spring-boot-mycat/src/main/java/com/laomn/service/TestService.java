package com.laomn.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laomn.dao.TestMapper;
import com.laomn.entites.Test;
import com.laomn.utils.TenantContextHolder;

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

	public int update(long id) {
		Test test = testMapper.selectByPrimaryKey(id);
		test.setCreTime(new Date());
		test.setName(TenantContextHolder.getTenant() + "- update");
		test.setCreTime(new Date());
		return testMapper.updateByPrimaryKey(test);
	}

	public int delete(long id) {
		return testMapper.deleteByPrimaryKey(id);
	}

}
