package com.laomn.controller;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;

@RequestMapping("/test")
@RestController
public class Test {
	
//	@PostConstruct
	public void post() {

		Transaction t = Cat.getProducer().newTransaction("test10", "my-deomo11111111123");
		try {
			
			for(int i=0;i<10000;i++) {
				System.out.println(i+" "+(i/0));
			}
			
			
			Cat.getProducer().logEvent("test10", "my-deomo11111111123", Event.SUCCESS, "keyValuePairs");
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception e) {
			
			Cat.getProducer().logError(e);
			// 用log4j记录系统异常，以便在Logview中看到此信息
			t.setStatus(e);
			Cat.getProducer().logEvent("test11", "my-1", Event.SUCCESS, "keyValuePairs");
			t.setStatus(Transaction.SUCCESS);
			// (CAT所有的API都可以单独使用，也可以组合使用，比如Transaction中嵌套Event或者Metric。)
			// (注意如果这里希望异常继续向上抛，需要继续向上抛出，往往需要抛出异常，让上层应用知道。) (如果认为这个异常在这边可以被吃掉，则不需要在抛出异常。)
		} finally {
			t.complete();
		}
	}
	@RequestMapping("1")
	public String test() {

		Transaction t = Cat.getProducer().newTransaction("test1", "your transaction name");
		try {
			
			for(int i=0;i<10000;i++) {
				System.out.println(i);
			}
			
			
			Cat.getProducer().logEvent("test1", "your event name", Event.SUCCESS, "keyValuePairs");
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception e) {
			Cat.getProducer().logError(e);
			// 用log4j记录系统异常，以便在Logview中看到此信息
			t.setStatus(e);
			throw e;
			// (CAT所有的API都可以单独使用，也可以组合使用，比如Transaction中嵌套Event或者Metric。)
			// (注意如果这里希望异常继续向上抛，需要继续向上抛出，往往需要抛出异常，让上层应用知道。) (如果认为这个异常在这边可以被吃掉，则不需要在抛出异常。)
		} finally {
			t.complete();
		}
		return "1";
	}

	@RequestMapping("2")
	public String test2() {
		return "2";
	}

	@RequestMapping("3")
	public String test3() {
		return "3";
	}

	@RequestMapping("4")
	public String test4() {
		return "4";
	}
}
