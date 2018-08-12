package com.laomn.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * 客户端处理器
 * 
 * @author xwalker
 */
public class JDClientHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 链路链接成功
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		System.out.println("客户端与服务端通道-开启：" + ctx.channel().localAddress() + "channelActive");
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

		String sSendMsg = doAddBaseMsgHeader(buf);
		ctx.writeAndFlush(sSendMsg);
		// File fileToSend = new
		// File("E:\\BaiduNetdiskDownload\\gateway\\gateway\\gatewayTestXML\\GD71.xml");
		// byte[] buf = new byte[(int) fileToSend.length()];
		// ctx.writeAndFlush(buf);
	}

	private void sendFile(ChannelHandlerContext ctx) {
		// 开始执行
		RandomAccessFile raf = null;
		try {
			File fileToSend = new File("E:\\BaiduNetdiskDownload\\gateway\\gateway\\gatewayTestXML\\GD71.xml");
			byte[] buf = new byte[(int) fileToSend.length()];
			String sSendMsg = doAddBaseMsgHeader(buf);
			// System.out.println(sSendMsg);

			// System.out.println("客户端准备发送的数据包：" + sSendMsg);
			// ctx.write(Unpooled.copiedBuffer(sSendMsg, CharsetUtil.UTF_8));
			ctx.writeAndFlush(toXml());
			// fileToSend = new
			// File("E:\\BaiduNetdiskDownload\\gateway\\gateway\\gatewayTestXML\\GD71.xml");
			// raf = new RandomAccessFile(fileToSend, "rw");
			// ChunkedFile chunkedFile = new ChunkedFile(raf);
			// ctx.writeAndFlush(chunkedFile).addListener(new
			// ChannelFutureListener() {
			// @Override
			// public void operationComplete(ChannelFuture future) throws
			// Exception {
			// future.channel().close();
			// }
			// });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toXml() {
		SAXReader saxReader = new SAXReader();
		Document document;
		String xmlString = "";
		try {
			document = saxReader.read(new File("E:\\BaiduNetdiskDownload\\gateway\\gateway\\gatewayTestXML\\GD71.xml"));
			xmlString = document.asXML();// 将xml内容转化为字符串
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			xmlString = "";
		}
		// String xmlString=document.asXML();
		System.out.println(xmlString);
		return xmlString;

	}

	public static String doAddBaseMsgHeader(byte[] bDoc) {
		String sSendMsg = null;
		try {
			sSendMsg = new String(bDoc, "gb2312");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		String sLength = "0000000000";
		int iMsgSize = new Integer(bDoc.length).toString().length();
		sSendMsg = sLength.substring(0, sLength.length() - iMsgSize) + bDoc.length + sSendMsg;
		return sSendMsg;
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端与服务端通道-关闭：" + ctx.channel().localAddress() + "channelInactive");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// Command responseMsg = (Command) msg;
		// System.out.println(responseMsg.getNum());
		// responseMsg.setNum(responseMsg.getNum() + 1);
		String rev = getMessage((ByteBuf) msg);
		System.out.println("channelRead:   " + rev);
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