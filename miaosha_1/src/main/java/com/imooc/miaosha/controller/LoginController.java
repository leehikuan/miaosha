package com.imooc.miaosha.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	 	@RequestMapping("/to_login")
//	    @ResponseBody
	    String toLogin() {
	        return "login";
	    }
	 	//1.rest api json输出 2.页面
	 	@RequestMapping("/do_login")
	    @ResponseBody
	    public boolean doLogin(HttpServletRequest request) {
	 		boolean login=loginService.doLogin(request);
	 		return login;
	       // return new Result(0, "success", "hello,imooc");
	    }
	 	
}
