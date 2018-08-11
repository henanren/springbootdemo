package com.laomn.utils;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

public class Constants {
	public static final ConcurrentHashMap<String, Channel> CHANNEL_CACHE = new ConcurrentHashMap<String, Channel>();
	public static final ConcurrentHashMap<String, Channel> CUSTOMER_CHANNEL_CACHE = new ConcurrentHashMap<String, Channel>();
	public static final String RECEIVE_QUEUE = "hello2";
	public static final String SEND_QUEUE = "hello";
	// 客户
	public static final String CUSTOMER_CLIENT_TO_OUTER_SERVER_SEND = "0";
	public static final String CUSTOMER_CLIENT_TO_OUTER_SERVER_RECEIVE = "1";

	// 内部
	public static final String OUTER_CLIENT_TO_INNER_SERVER_SEND = "0";
	public static final String OUTER_CLIENT_TO_INNER_SERVER_RECEIVE = "1";
}
