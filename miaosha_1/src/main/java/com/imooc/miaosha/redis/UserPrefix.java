package com.imooc.miaosha.redis;

public class UserPrefix extends BasePrefix {

	private static final int TOKEN_EXPIRE=3600*24;
	public UserPrefix(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static UserPrefix token=new UserPrefix(TOKEN_EXPIRE, "tk");
	public static UserPrefix getById=new UserPrefix(TOKEN_EXPIRE, "id");
}
