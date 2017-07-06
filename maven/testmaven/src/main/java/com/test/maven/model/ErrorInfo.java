package com.test.maven.model;

public class ErrorInfo {
	
	// 错误信息
	public String msg;
	
	// 错误模块
	public String model;
	
	
	public ErrorInfo() {
	}

	public ErrorInfo(String msg, String model) {
		super();
		this.msg = msg;
		this.model = model;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
