package com.laomn.client;

import com.laomn.msg.Command;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 客户端处理器
 * 
 * @author xwalker
 */
public class JDClientHandler extends ChannelHandlerAdapter {

	private int num ;
	 
	public JDClientHandler(int num) {
		this.num =num ;
	}

	/**
	 * 链路链接成功
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Command responseMsg = new Command();
		responseMsg.setNum(num);

//		System.out.println(responseMsg.getNum());
		ctx.writeAndFlush(responseMsg);
		ctx.close();
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