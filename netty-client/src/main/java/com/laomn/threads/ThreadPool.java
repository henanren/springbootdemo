package com.laomn.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThreadPool {
	@Value("${thread.count}")
	private int cnt;
	public static ExecutorService POOL = null;

	@PostConstruct
	public void init() {
		POOL = Executors.newFixedThreadPool(cnt);
	}
}
