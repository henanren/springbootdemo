package com.laomn.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 测试得到线程池中的当前活动线程
 * 
 * @author keji
 * @2013-4-7
 */
public class TestPool {
	public static void main(String[] args) {
		ExecutorService exec = null;
		try {
			exec = Executors.newFixedThreadPool(10);
			// 想线程池中放入三个任务
			exec.execute(new Task());
			exec.execute(new Task());
			exec.execute(new Task());
			// 延迟一下,因为三个任务放入需要时间
			Thread.sleep(200);// 重点到了!!
			// 将exec转换为ThreadPoolExecutor,ThreadPoolExecutor有方法
			// getActiveCount()可以得到当前活动线程数
			int threadCount = ((ThreadPoolExecutor) exec).getActiveCount();
			int CorePoolSize = ((ThreadPoolExecutor) exec).getCorePoolSize();
			((ThreadPoolExecutor) exec).setCorePoolSize(5);
			System.out.println(threadCount + " CorePoolSize : " + CorePoolSize);
			Thread.sleep(4000);
			threadCount = ((ThreadPoolExecutor) exec).getActiveCount();
			System.out.println(threadCount);
			exec.execute(new Task());
			exec.execute(new Task());
			exec.execute(new Task());
			Thread.sleep(200);
			threadCount = ((ThreadPoolExecutor) exec).getActiveCount();
			System.out.println(threadCount);

			CorePoolSize = ((ThreadPoolExecutor) exec).getCorePoolSize();
			System.out.println(threadCount + " CorePoolSize1 : " + CorePoolSize);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (exec != null) {
				exec.shutdown();
			}
		}
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
