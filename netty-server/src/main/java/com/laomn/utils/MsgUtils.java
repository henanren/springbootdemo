package com.laomn.utils;

import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

public class MsgUtils {
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

	public static String getMessage(ByteBuf buf) {
		byte[] con = new byte[buf.readableBytes()];
		buf.readBytes(con);
		try {
			return new String(con, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
