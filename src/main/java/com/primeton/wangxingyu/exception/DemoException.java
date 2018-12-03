package com.primeton.wangxingyu.exception;

import org.springframework.http.HttpStatus;

public class DemoException extends Exception {

	private static final long serialVersionUID = -3876319857610564892L;

	public static final Integer SAVE_USER_INFO_FAILED = 2001;

	public static final Integer GET_USER_INFO_FAILED = 2002;

	public static final Integer WECHAT_VALID_FAILED = 2003;

	public static final Integer GET_USER_AUTH_INFO_FAILED = 2004;

	public static final Integer SAVE_USER_AUTH_INFO_FAILED = 2005;

	public static final Integer POST_USER_INFO_FAILED = 2007;

	public static final Integer POST_PASSWORD_INFO_FAILED = 2008;

	public static final Integer POST_ID_INFO_FAILED = 2009;

	public static final Integer DELETE_ID_INFO_FAILED = 2010;

	public static final Integer DELETE_ID_Y_FAILED = 2011;

	public static final Integer LOGIN_INFO_Y_FAILED = 2012;

	public static final Integer PUT_DEPO_FAILED = 2013;

	public static final Integer PUT_DEP_FAILED = 2014;

	public static final Integer PUT_ID_FAILED = 2015;

	public static final Integer DELETE_ID_FAILED = 2016;

	public static final Integer DEL_ID_Y_FAILED = 2017;

	public static final Integer POST_ID_N_FAILED = 2018;

	public static final Integer POST_NAME_N_FAILED = 2019;

	public static final Integer POST_XJID_FAILED = 2020;

	public static final Integer POST_XJID_N_FAILED = 2021;

	public static final Integer POST_XJID_YY_FAILED = 2022;

	public static final Integer POST_XJID_NN_FAILED = 2023;

	public static final Integer DEL_XJID_N_FAILED = 2024;

	public static final Integer GET_XJID_N_FAILED = 2025;

	public HttpStatus httpStatus;

	public Integer errCode;

	public String message;

	public DemoException(Integer errCode, String message) {
		this.errCode = errCode;
		this.message = message;

	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DemoException [httpStatus=" + httpStatus + ", errCode=" + errCode + ", message=" + message + "]";
	}

}
