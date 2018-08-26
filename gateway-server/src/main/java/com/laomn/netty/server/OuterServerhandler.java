package com.laomn.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laomn.mq.sender.MsgSender;
import com.laomn.msg.Msg;
import com.laomn.utils.Constants;

@Component
@Sharable
public class OuterServerhandler extends ChannelInboundHandlerAdapter {
	// ChannelHandlerAdapter
	private static final Logger logger = LoggerFactory.getLogger(OuterServerhandler.class);
	@Autowired
	private MsgSender msgSender;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		super.channelRead(ctx, msg);
		logger.info("OuterServerhandler服务器收到连接的数据为msg: " + msg.toString());
		Msg mssg = (Msg) msg;
		// ByteBuf buf = (ByteBuf) mssg.get;
		// String rev = MsgUtils.getMessage(buf);
		logger.info(" OuterServerhandler服务器收到连接的数据为rev :  " + mssg.getBody());
		// 第一次握手
		// if (Constants.CUSTOMER_CLIENT_TO_OUTER_SERVER_SEND.equals(rev)) {
		// ctx.writeAndFlush(Constants.CUSTOMER_CLIENT_TO_OUTER_SERVER_RECEIVE);
		// Constants.CHANNEL_CACHE.put("jd", ctx.channel());
		// Constants.CUSTOMER_CHANNEL_CACHE.put(UUIDUtils.getUUID(),
		// ctx.channel());
		// } else {
		// // MQ
		// msgSender.send(rev);
		// }
		String customer_no = "123456";
		Constants.CUSTOMER_CHANNEL_CACHE.put(customer_no, ctx.channel());
		// 同步异步
		boolean flag = false;
		if (flag) {
			ctx.writeAndFlush(1);
		}
		// MQ
		msgSender.send(mssg.getBody());
		// ctx.writeAndFlush(1);

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
		super.channelActive(ctx);
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
		super.channelInactive(ctx);
		logger.info(ctx.channel().localAddress().toString() + " channelInactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
		// cause.printStackTrace();
		// ctx.close();
		Channel channel = ctx.channel();
		if (channel.isActive())
			ctx.close();
	}
}