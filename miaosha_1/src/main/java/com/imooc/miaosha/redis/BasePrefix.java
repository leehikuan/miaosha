package com.imooc.miaosha.redis;

public abstract class BasePrefix implements KeyPrefix {

	protected int expireSeconds;
	protected String prefix;
	
	public BasePrefix(String prefix) {
		super();
		this.expireSeconds = 0;
		this.prefix = prefix;
	}
	public BasePrefix(int expireSeconds, String prefix) {
		super();
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	@Override
	public int expireSeconds() {
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String className=getClass().getSimpleName();
		return className+":"+prefix;
	}

}
