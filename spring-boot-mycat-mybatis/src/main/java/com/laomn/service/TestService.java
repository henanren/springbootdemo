package com.laomn.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laomn.Caller;
import com.laomn.common.SpringContext;
import com.laomn.common.TenantContextHolder;
import com.laomn.dao.TestMapper;
import com.laomn.entites.Test;

@Service
public class TestService {
	private static int ID = 0;
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private TenantContextHolder tenantContextHolder;

	public Test selectByPrimaryKey(Long id) {
		Caller caller = (Caller) SpringContext.getBean(Caller.class);
		return testMapper.selectByPrimaryKey(id);
	}

	public int insert() {
		Test test = new Test();
		test.setCreTime(new Date());
		test.setName(tenantContextHolder.getTenant());
		return testMapper.insert(test);
	}

	public int update(long id) {
		Test test = testMapper.selectByPrimaryKey(id);
		test.setCreTime(new Date());
		test.setName(tenantContextHolder.getTenant() + "- update");
		test.setCreTime(new Date());
		return testMapper.updateByPrimaryKey(test);
	}

	public int delete(long id) {
		return testMapper.deleteByPrimaryKey(id);
	}

}
