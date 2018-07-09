package com.laomn.example.mongodb;

import org.apache.log4j.MDC;

public class Test extends Thread {
	private int i;

	public Test() {
	}

	public Test(int i) {
		this.i = i;
	}

	public void run() {
		System.out.println(++i);
		MDC.put("username", i);

		for (int j = 0; j < 100; j++) {
			System.out.println("aaa" + i);
			if (j == 10) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("run: " + i + "     " + MDC.get("username"));
	}

	public static void main(String args[]) throws InterruptedException {
		Test t1 = new Test(1);
		t1.start();
		Test t2 = new Test(2);
		t2.start();
	}
}