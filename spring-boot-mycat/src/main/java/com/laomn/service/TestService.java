package com.laomn.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laomn.dao.Test123Mapper;
import com.laomn.dao.TestMapper;
import com.laomn.entites.Test;
import com.laomn.utils.TenantContextHolder;

@Service
public class TestService {
	private static int ID = 0;
	@Autowired
	private TestMapper testMapper;

	@Autowired
	private Test123Mapper test123Mapper;

	public Test selectByPrimaryKey(Long id) {
		return testMapper.selectByPrimaryKey(id);
	}

	public Test selectByName1(String name1) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name1", name1);
		map.put("dataNodeName", "dn1");
		return testMapper.selectByName1(map);
	}

	public Test selectByName11(String name1) {
		// 设置计数器，从0开始
		final CountDownLatch countDownLatch = new CountDownLatch(dns.length);
		List<Test> list = new ArrayList<Test>();
		for (int i = 0; i < dns.length; i++) {
			Future<Test> future = cachedThreadPool.submit(new MyThread2(name1, dns[i]));
			try {
				while (!future.isDone()) {
					Test t = future.get();
					if (future.isDone()) {
						if (t != null) {
							System.out.println(t.toString());
							list.add(t);
						}
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				countDownLatch.countDown();
			}
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (Test t : list) {
			if (t != null)
				return t;
		}

		return null;

	}

	class MyThread2 implements Callable<Test> {
		private String name1;
		private String dataNodeNmae;

		public MyThread2(String name1, String dataNodeNmae) {
			this.name1 = name1;
			this.dataNodeNmae = dataNodeNmae;
		}

		@Override
		public Test call() throws Exception {
			TenantContextHolder.setTenant("company1");
			Map<String, String> map = new HashMap<String, String>();
			map.put("name1", name1);
			map.put("dataNodeName", dataNodeNmae);
			return testMapper.selectByName1(map);
		}
	}

	public Test selectByName(String name) {
		return testMapper.selectByName(name);
	}

	ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	String dns[] = { "dn1", "dn4", "dn5" };

	// @PostConstruct
	public void init() {

		for (int i = 0; i < 10; i++) {
			cachedThreadPool.execute(new Runnable() {

				@Override
				public void run() {
					TenantContextHolder.setTenant("company1");
					for (int i = 0; i < 100000000; i++) {
						insert();
						System.out.println(i);
					}
				}
			});
		}

	}

	@PostConstruct
	public void init2() {

		for (int i = 0; i < 10; i++) {
			cachedThreadPool.execute(new Runnable() {

				@Override
				public void run() {
					TenantContextHolder.setTenant("company1");
					for (int i = 0; i < 100000000; i++) {
						insert();
						System.out.println(i);
					}
				}
			});
		}

	}

	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式

	public int insert() {
		Test test = new Test();
		test.setCreTime(new Date());
		test.setName(FORMAT.format(new Date()) + "_" + TenantContextHolder.getTenant() + "_" + random());
		test.setName1(FORMAT.format(new Date()) + "_" + TenantContextHolder.getTenant() + "_" + random());
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

	public static void main(String args[]) {
		System.out.println(random());
		System.out.println(FORMAT.format(new Date()));
	}

	private static int random() {
		return (int) (1 + Math.random() * (100000000 - 1 + 1));
	}

}
