package com.bank.service;

import com.bank.beans.User;

public interface IUserService {

	boolean verifyUser(User user);

	User loadUser(String userId);

	User saveUser(User user);

	boolean deleteUser(String userId);
	
}
