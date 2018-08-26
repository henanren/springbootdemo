package com.laomn.customer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.laomn.msg.Msg;

public class CustomerClientHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(CustomerClientHandler.class);

	/**
	 * 链路链接成功
	 */
	// @Override
	public void channelActive1(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		logger.info("客户端与服务端通道-开启：" + ctx.channel().localAddress() + "channelActive");
		// ctx.writeAndFlush(toXml());
		File fileToSend = new File("E:\\BaiduNetdiskDownload\\gateway\\gateway\\gatewayTestXML\\GD71.xml");
		byte[] buf = new byte[(int) fileToSend.length()];

		InputStream in = null;
		try {
			in = new FileInputStream(fileToSend);
			in.read(buf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}

		String sSendMsg = "qqqqqqq";// MsgUtils.doAddBaseMsgHeader(buf);
		Msg mssg = new Msg();
		mssg.setBody(sSendMsg);
		ctx.writeAndFlush(mssg);
		logger.error("CustomerClientHandler : " + sSendMsg);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String sSendMsg = "qqqqqqq";// MsgUtils.doAddBaseMsgHeader(buf);
		Msg mssg = new Msg();
		mssg.setBody(sSendMsg);
		ctx.writeAndFlush(mssg);
		logger.error("CustomerClientHandler : " + sSendMsg);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		// logger.info("客户端与服务端通道-关闭：" + ctx.channel().localAddress() +
		// "channelInactive");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		super.channelRead(ctx, msg);
		// Command responseMsg = (Command) msg;
		// System.out.println(responseMsg.getNum());
		// responseMsg.setNum(responseMsg.getNum() + 1);
		// String rev = getMessage((ByteBuf) msg);
		logger.info("channelRead:   " + msg);
		// ctx.writeAndFlush(responseMsg);

		ctx.close();

	}

	private String getMessage(ByteBuf buf) {
		byte[] con = new byte[buf.readableBytes()];
		buf.readBytes(con);
		try {
			return new String(con, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	// @Override
	public void exceptionCaught1(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
		// cause.printStackTrace();
		// ctx.close();
		Channel channel = ctx.channel();
		if (channel.isActive())
			ctx.close();
	}

}