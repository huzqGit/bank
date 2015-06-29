package com.bank.dao;

import java.util.List;

import com.bank.beans.User;


public interface IUserDao {
	
	//根据用户名称 查询用户信息
	public User findUserByUsername(String username) throws Exception;

	public User verifyUser(User user);

	public User getUserById(String userId);

	public String insertUser(User user);
	
	public void updateUser(User user);

	public boolean deleteUser(String userId);
	
	public boolean deleteUsers(String userIds);

	public List<User> loadAllUsers(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);
	
	public List<User> loadAllUsersByOrganIds(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder, String organIds);

	public List<User> loadAllUsersByOrganId(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder, String organId);

	public int getAllUsersByOrganId(String key, String selectOrganId);

	public int getAllUsers(String key);

	public int getAllUsersByOrganIds(String key, String tempOrganIds);

}
