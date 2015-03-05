package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.User;
import com.bank.dao.IUserDao;
import com.bank.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Override
	public boolean verifyUser(User user) {
		boolean flag = userDao.verifyUser(user);
		return flag;
	}

}
