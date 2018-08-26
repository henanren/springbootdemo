package com.laomn.utils;

import java.util.ResourceBundle;

public class PropertieUtils {
	public static String BASE_PATH = "properties";
	public static String SP = "/";
	// 获得Class
	public static ResourceBundle CLASS = ResourceBundle.getBundle(BASE_PATH + SP + "class");

	// 获得Class
	public static String getValueFromClass(String key) {
		return CLASS.getString(key);
	}

	// 获得communication
	public static ResourceBundle communication = ResourceBundle.getBundle(BASE_PATH + SP + "communication");

	// 获得communication
	public static String getValueFromCommunication(String key) {
		return communication.getString(key);
	}

	// 获得connect
	public static ResourceBundle connect = ResourceBundle.getBundle(BASE_PATH + SP + "connect");

	// 获得connect
	public static String getValueFromConnect(String key) {
		return connect.getString(key);
	}

	// 获得Dispatcher
	public static ResourceBundle Dispatcher = ResourceBundle.getBundle(BASE_PATH + SP + "Dispatcher");

	// 获得Dispatcher
	public static String getValueFromDispatcher(String key) {
		return Dispatcher.getString(key);
	}

	// 获得exchange
	public static ResourceBundle exchange = ResourceBundle.getBundle(BASE_PATH + SP + "exchange");

	// 获得exchange
	public static String getValueFromExchange(String key) {
		return exchange.getString(key);
	}

	// 获得FromJerTCPFeeder
	public static ResourceBundle FromJerTCPFeeder = ResourceBundle.getBundle(BASE_PATH + SP + "FromJerTCPFeeder");

	// 获得FromJerTCPFeeder
	public static String getValueFromFromJerTCPFeeder(String key) {
		return FromJerTCPFeeder.getString(key);
	}

	// 获得GateWayJerServer
	public static ResourceBundle GateWayJerServer = ResourceBundle.getBundle(BASE_PATH + SP + "GateWayJerServer");

	// 获得GateWayJerServer
	public static String getValueFromGateWayJerServer(String key) {
		return GateWayJerServer.getString(key);
	}

	// 获得host
	public static ResourceBundle host = ResourceBundle.getBundle(BASE_PATH + SP + "host");

	// 获得host
	public static String getValueFromHost(String key) {
		return host.getString(key);
	}

	// 获得MultipleAdapter
	public static ResourceBundle MultipleAdapter = ResourceBundle.getBundle(BASE_PATH + SP + "MultipleAdapter");

	// 获得MultipleAdapter
	public static String getValueFromMultipleAdapter(String key) {
		return MultipleAdapter.getString(key);
	}

	// 获得MultipleHttpAdapter
	public static ResourceBundle MultipleHttpAdapter = ResourceBundle.getBundle(BASE_PATH + SP + "MultipleHttpAdapter");

	// 获得MultipleHttpAdapter
	public static String getValueFromMultipleHttpAdapter(String key) {
		return MultipleHttpAdapter.getString(key);
	}

	// 获得MultipleJerAdaptor
	public static ResourceBundle MultipleJerAdaptor = ResourceBundle.getBundle(BASE_PATH + SP + "MultipleJerAdaptor");

	// 获得MultipleJerAdaptor
	public static String getValueFromMultipleJerAdaptor(String key) {
		return MultipleJerAdaptor.getString(key);
	}

	// 获得parm
	public static ResourceBundle parm = ResourceBundle.getBundle(BASE_PATH + SP + "parm");

	// 获得parm
	public static String getValueFromParm(String key) {
		return CLASS.getString(key);
	}

	// 获得StdAdapter
	public static ResourceBundle StdAdapter = ResourceBundle.getBundle(BASE_PATH + SP + "StdAdapter");

	// 获得StdAdapter
	public static String getValueFromStdAdapter(String key) {
		return CLASS.getString(key);
	}

	// 获得stdconn
	public static ResourceBundle stdconn = ResourceBundle.getBundle(BASE_PATH + SP + "stdconn");

	// 获得stdconn
	public static String getValueFromStdconn(String key) {
		return stdconn.getString(key);
	}

	// 获得StdTCPFeeder
	public static ResourceBundle StdTCPFeeder = ResourceBundle.getBundle(BASE_PATH + SP + "StdTCPFeeder");

	// 获得StdTCPFeeder
	public static String getValueFromStdTCPFeeder(String key) {
		return StdTCPFeeder.getString(key);
	}

	// 获得TCPFeeder
	public static ResourceBundle TCPFeeder = ResourceBundle.getBundle(BASE_PATH + SP + "TCPFeeder");

	// 获得TCPFeeder
	public static String getValueFromTCPFeeder(String key) {
		return TCPFeeder.getString(key);
	}

	// 获得ToJerTCPFeeder
	public static ResourceBundle ToJerTCPFeeder = ResourceBundle.getBundle(BASE_PATH + SP + "ToJerTCPFeeder");

	// 获得ToJerTCPFeeder
	public static String getValueFromToJerTCPFeeder(String key) {
		return ToJerTCPFeeder.getString(key);
	}

	// 获得UniverTestAdaptor
	public static ResourceBundle UniverTestAdaptor = ResourceBundle.getBundle(BASE_PATH + SP + "UniverTestAdaptor");

	// 获得UniverTestAdaptor
	public static String getValueFromUniverTestAdaptor(String key) {
		return UniverTestAdaptor.getString(key);
	}

	// 获得Lenovo-PCLog
	public static ResourceBundle Lenovo_PCLog = ResourceBundle.getBundle(BASE_PATH + SP + "Jer_log/Lenovo-PCLog");

	// 获得Lenovo-PCLog
	public static String getValueFromLenovo_PCLog(String key) {
		return Lenovo_PCLog.getString(key);
	}

	// 获得Zhou_PClog
	public static ResourceBundle Zhou_PClog = ResourceBundle.getBundle(BASE_PATH + SP + "Jer_log/Zhou-PClog");

	// 获得Zhou_PClog
	public static String getValueFromZhou_PClog(String key) {
		return Zhou_PClog.getString(key);
	}

}
