package com.laomn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laomn.entites.Test;
import com.laomn.service.TestService;

@RestController
@RequestMapping("/")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/list/{id:\\d+}", method = RequestMethod.GET)
	public Test findById(@PathVariable("id") long id) {
		return testService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/list1/{name}", method = RequestMethod.GET)
	public Test selectByName(@PathVariable("name") String name) {
		long startTime = System.currentTimeMillis();// 记录开始时间

		Test test = testService.selectByName(name);

		long endTime = System.currentTimeMillis();// 记录结束时间

		float excTime = (float) (endTime - startTime) / 1000;

		System.out.println("name 执行时间：" + excTime + " s");
		return test;
	}

	@RequestMapping(value = "/list2/{name1}", method = RequestMethod.GET)
	public Test selectByName1(@PathVariable("name1") String name1) {
		long startTime = System.currentTimeMillis();// 记录开始时间
		Test test = testService.selectByName1(name1);
		long endTime = System.currentTimeMillis();// 记录结束时间

		float excTime = (float) (endTime - startTime) / 1000;

		System.out.println("name1 执行时间：" + excTime + " s");
		return test;
	}

	@RequestMapping(value = "/list21/{name1}", method = RequestMethod.GET)
	public Test selectByName11(@PathVariable("name1") String name1) {
		long startTime = System.currentTimeMillis();// 记录开始时间
		Test test = testService.selectByName11(name1);
		long endTime = System.currentTimeMillis();// 记录结束时间

		float excTime = (float) (endTime - startTime) / 1000;

		System.out.println("name1 执行时间：" + excTime + " s");
		return test;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public int insert() {
		return testService.insert();
	}

	@RequestMapping(value = "/del/{id:\\d+}", method = RequestMethod.GET)
	public int del(@PathVariable("id") long id) {
		return testService.delete(id);
	}

	@RequestMapping(value = "/update/{id:\\d+}", method = RequestMethod.GET)
	public int update(@PathVariable("id") long id) {
		return testService.update(id);
	}

}
