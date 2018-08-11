package com.laomn.client.inner;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.laomn.client.outer.OuterClient;
import com.laomn.utils.Constants;

@Component
public class InnerClientHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(InnerClientHandler.class);

	/**
	 * 链路链接成功
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		logger.info("客户端与服务端通道-开启：" + ctx.channel().localAddress() + "channelActive");

		// File fileToSend = new
		// File("E:\\BaiduNetdiskDownload\\gateway\\gateway\\gatewayTestXML\\GD71.xml");
		// byte[] buf = new byte[(int) fileToSend.length()];
		//
		// InputStream in = null;
		// try {
		// in = new FileInputStream(fileToSend);
		// in.read(buf);
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// if (in != null)
		// in.close();
		// }
		// String sSendMsg = MsgUtils.doAddBaseMsgHeader(buf);
		ctx.writeAndFlush(Constants.INNER_CLIENT_TO_BUSINESS_SERVER_SEND);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("客户端与服务端通道-关闭：" + ctx.channel().localAddress() + "channelInactive");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		String rev = getMessage((ByteBuf) msg);

		if (Constants.INNER_CLIENT_TO_BUSINESS_SERVER_RECEIVE.equals(rev)) {
			logger.info("InnerClientHandler  连接成功 ：" + rev);
		} else {
			// 发送给netty server 处理
			OuterClient.sendMsg(rev);
		}
		// ctx.close();

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

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}