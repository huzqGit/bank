package com.bank.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bank.beans.UserRole;
import com.bank.dao.IUserRoleDao;
import com.bank.service.IUserRoleService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("userRoleSerivce")
public class UserRoleServiceImpl extends GenericServiceImpl<UserRole, String> implements
		IUserRoleService {
	private static Logger log = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	
	@Resource
	private IUserRoleDao userRoleDao;
	
	

	public GenericDAO<UserRole, String> getGenericDAO() {
		return userRoleDao;
	}



	@Override
	public List<UserRole> getAllUserRolesById(String roleId) {
		return userRoleDao.getAllUserRolesById(roleId);
	}


}
