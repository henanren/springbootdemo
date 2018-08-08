package com.laomn.msg;

import java.io.Serializable;

/**
 * Created by xvshu on 2016/7/13.
 */
public class Command implements Serializable {

	private static final long serialVersionUID = 7590999461767050471L;

	private String actionName;
	private int num;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}