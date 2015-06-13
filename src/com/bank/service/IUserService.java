package com.bank.service;

import java.util.List;

import com.bank.beans.User;

public interface IUserService {

	User verifyUser(User user);

	User loadUser(String userId);

	String saveUser(User user);

	void updateUser(User user);

	boolean deleteUser(String userId);
	
	boolean deleteUsers(String userIds);

	List<User> loadAllUsers(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);
	
	List<User> loadAllUsersByOrganIds(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder, String organIds);
	
	List<User> loadAllUsersByOrganId(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder, String organId);
	
}
