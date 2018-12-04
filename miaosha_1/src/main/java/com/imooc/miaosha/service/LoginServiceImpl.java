package com.imooc.miaosha.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.redis.UserPrefix;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.util.UUIDUtil;
import com.imooc.miaosha.vo.User;

@Service
public class LoginServiceImpl implements LoginService {

	public static final String COOKI_NAME_TOKEN = "token";
	@Autowired
	private UserDao userDao;

	@Override
	public boolean doLogin(HttpServletRequest request,HttpServletResponse response) {
//		String 
//		User u=new User();
		String mobile=request.getParameter("mobile");
		String passWord=request.getParameter("password");
		User u=userDao.getByName(mobile);
		if(u==null) {
			throw new GlobalException(CodeMsg.USER_NOT_EXISTS);
		}
		String password=u.getPassWord();
		String salt=u.getSalt();
		String passwordMd5=MD5Util.formPassToDBPass(password, salt);
		if(!passWord.equals(passwordMd5)) {
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		String uuid=UUIDUtil.uuid();
		addCookie(u,uuid,response);
		return false;
	}

	private void addCookie(User u, String uuid, HttpServletResponse response) {
		Cookie cookie=new Cookie(COOKI_NAME_TOKEN,uuid);
		cookie.setMaxAge(UserPrefix.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
