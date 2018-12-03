package com.primeton.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author
 * @date
 * @description 全局异常处理: 使用 @RestControllerAdvice + @ExceptionHandler 注解方式实现全
 *              局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	/**
	 * @author
	 * @date
	 * @param e
	 *            异常
	 * @description 处理所有不可知的异常
	 */
	@ExceptionHandler({ Exception.class }) // 申明捕获那个异常类
	@ResponseBody
	public Object globalExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		if (e instanceof DemoException) {
			DemoException ex = (DemoException) e;
			logger.error(e);
			return new ResponseEntity<ResponseResultUtil>(new ResponseResultUtil(ex.getErrCode(), ex.getMessage()),
					ex.getHttpStatus());
		}
		return e;
	}

	/**
	 * @author
	 * @date
	 * @param e
	 *            异常
	 * @description 处理所有业务异常
	 */
	@ExceptionHandler({ DemoException.class })
	public ResponseEntity BusinessExceptionHandler(DemoException e) {
		this.logger.error(e);
		HttpStatus httpStatus = HttpStatus.EXPECTATION_FAILED;
		return new ResponseEntity<ResponseResultUtil>(new ResponseResultUtil(e.getErrCode(), e.getMessage()),
				httpStatus);
	}

}
