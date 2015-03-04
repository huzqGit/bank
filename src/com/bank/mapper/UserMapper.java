package com.bank.mapper;

import java.util.List;

import com.bank.beans.User;


public interface UserMapper {
	
	//根据用户名称 查询用户信息
	public User  findUserByUsername(String username) throws Exception;
	
	//查询用户列表
	public List<User> findUserList(User user)throws Exception;
	
	//查询用户列表总数
	public int findUserCount(User user)throws Exception;
	
	

}
