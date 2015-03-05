package com.bank.dao;

import com.bank.beans.User;


public interface IUserDao {
	
	//根据用户名称 查询用户信息
	public User findUserByUsername(String username) throws Exception;

	public boolean verifyUser(User user);

}
