package com.imooc.miaosha.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	private String userName;
	private String passWord;
	private String salt;
}
