package com.imooc.miaosha.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.result.Result;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler
	Result<String> methodHandle(Exception e){
		if(e instanceof GlobalException) {
			GlobalException ex=(GlobalException)e;
			return  Result.error(ex.getCm());
		}
		return null;
		
	}
}
