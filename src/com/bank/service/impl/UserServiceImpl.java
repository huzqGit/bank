package com.bank.service.impl;

import java.util.List;

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
	public User verifyUser(User user) {
		User retrunUser = userDao.verifyUser(user);
		return retrunUser;
	}
	@Override
	public User loadUser(String userId) {
		User user = userDao.getUserById(userId);
		return user;
	}
	@Override
	public String saveUser(User user) {
		String userId = userDao.insertUser(user);
		return userId;
	}
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}
	@Override
	public boolean deleteUser(String userId) {
		boolean flag = userDao.deleteUser(userId);
		return flag;
	}
	
	public boolean deleteUsers(String userIds) {
		boolean flag = userDao.deleteUsers(userIds);
		return flag;
	}
	
	@Override
	public List<User> loadAllUsers(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder) {
		List<User> users = userDao.loadAllUsers(key, pageIndex, pageSize, sortField, sortOrder);
		return users;
	}
	
	public List<User> loadAllUsersByOrganIds(String key, int pageIndex,
			int pageSize, String sortField, String sortOrder,
			String organIds) {
		return userDao.loadAllUsersByOrganIds(key, pageIndex, pageSize, sortField, sortOrder, organIds);
	}
	
	public List<User> loadAllUsersByOrganId(String key, int pageIndex,
			int pageSize, String sortField, String sortOrder,
			String organId) {
		return userDao.loadAllUsersByOrganId(key, pageIndex, pageSize, sortField, sortOrder, organId);
	}
	
}
