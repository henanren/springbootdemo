package com.laomn.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.laomn.utils.Constants;
import com.laomn.utils.MsgUtils;
import com.laomn.utils.UUIDUtils;

public class ReceiveServerhandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(ReceiveServerhandler.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		logger.info("msg: " + msg.toString());

		ByteBuf buf = (ByteBuf) msg;
		String rev = MsgUtils.getMessage(buf);
		logger.info(" 服务器收到数据为:  " + rev);

		Constants.CHANNEL_CACHE.put("jd", ctx.channel());
		Constants.CHANNEL_CACHE.put(UUIDUtils.getUUID(), ctx.channel());
		ctx.writeAndFlush("0000000000");

	}

	/*
	 * channelReadComplete
	 * 
	 * channel 通道 Read 读取 Complete 完成
	 * 
	 * 在通道读取完成后会在这个方法里通知，对应可以做刷新操作 ctx.flush()
	 */
	// @Override
	// public void channelReadComplete(ChannelHandlerContext ctx) throws
	// Exception {
	// ctx.flush();
	//
	// logger.info("服务端接收数据完毕..");
	// 第一种方法：写一个空的buf，并刷新写出区域。完成后关闭sock channel连接。
	// ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	// ctx.flush();
	// ctx.flush(); //
	// 第二种方法：在client端关闭channel连接，这样的话，会触发两次channelReadComplete方法。
	// ctx.flush().close().sync(); // 第三种：改成这种写法也可以，但是这中写法，没有第一种方法的好。
	// }

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info(ctx.channel().localAddress().toString() + " channelActive");
	}

	/*
	 * channelInactive
	 * 
	 * channel 通道 Inactive 不活跃的
	 * 
	 * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info(ctx.channel().localAddress().toString() + " channelInactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}