package com.imooc.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.imooc.miaosha.vo.User;

@Mapper
public interface UserDao {
	@Select("select * from user where userName=#{userName}")
	User getByName(String userName);
}
