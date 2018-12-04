package com.imooc.miaosha.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.vo.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean doLogin(HttpServletRequest request) {
//		String 
//		User u=new User();
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		User u=userDao.getByName(userName);
		if(u==null) {
			throw new GlobalException(CodeMsg.USER_NOT_EXISTS);
		}
		return false;
	}

}
