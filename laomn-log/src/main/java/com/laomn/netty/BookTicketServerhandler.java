package com.laomn.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 订票server端处理器
 * 
 * @author xwalker
 *
 */
public class BookTicketServerhandler extends ChannelHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Command responseMsg = (Command) msg;
		System.out.println(responseMsg.getNum());
		responseMsg.setNum(responseMsg.getNum() + 1);
		ctx.writeAndFlush(responseMsg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}