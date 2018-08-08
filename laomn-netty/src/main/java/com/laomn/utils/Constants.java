package com.laomn.utils;

import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

public class Constants {
	public static final ConcurrentHashMap <String,Channel>CHANNEL_CACHE=new ConcurrentHashMap<String,Channel>();

}
