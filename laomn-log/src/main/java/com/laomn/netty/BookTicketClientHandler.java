package com.laomn.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 客户端处理器
 * 
 * @author xwalker
 */
public class BookTicketClientHandler extends ChannelHandlerAdapter {

	public BookTicketClientHandler() {
	}

	/**
	 * 链路链接成功
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Command responseMsg = new Command();
		responseMsg.setNum(1);

		System.out.println(responseMsg.getNum());
		ctx.writeAndFlush(responseMsg);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Command responseMsg = (Command) msg;
		System.out.println(responseMsg.getNum());
		responseMsg.setNum(responseMsg.getNum() + 1);
		ctx.writeAndFlush(responseMsg);

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}