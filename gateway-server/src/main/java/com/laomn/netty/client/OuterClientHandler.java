package com.laomn.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.laomn.utils.MsgUtils;

@Component
public class OuterClientHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(OuterClientHandler.class);

	/**
	 * 链路链接成功
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		logger.info("OuterClientHandler客户端与服务端通道-开启：" + ctx.channel().localAddress() + "channelActive");

		ctx.writeAndFlush("0");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("OuterClientHandler客户端与服务端通道-关闭：" + ctx.channel().localAddress() + "channelInactive");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		String rev = MsgUtils.getMessage((ByteBuf) msg);
		if ("1".equals(rev)) {
			logger.info("OuterClientHandler连接成功 :   " + rev);
		} else {
			logger.info("OuterClientHandler连接失败  :   " + rev);
		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}