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
