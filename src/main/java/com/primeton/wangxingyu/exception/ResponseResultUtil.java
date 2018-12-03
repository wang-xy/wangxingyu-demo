package com.primeton.wangxingyu.exception;

public class ResponseResultUtil {

	private Integer errCode;
	private String Message;

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public ResponseResultUtil(Integer errCode, String message) {
		super();
		this.errCode = errCode;
		this.Message = message;
	}

}