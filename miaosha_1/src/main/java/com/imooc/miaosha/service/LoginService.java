package com.imooc.miaosha.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
	
	boolean doLogin(HttpServletRequest request,HttpServletResponse response);
}
