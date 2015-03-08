package com.bank.service;

import java.util.List;

import com.bank.beans.User;

public interface IUserService {

	boolean verifyUser(User user);

	User loadUser(String userId);

	String saveUser(User user);

	void updateUser(User user);

	boolean deleteUser(String userId);

	List<User> loadAllUsers(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);

	
}
