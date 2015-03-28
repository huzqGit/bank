package com.bank.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.UserRole;
import com.bank.dao.IUserRoleDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends GenericMyBatisDAOSupport<UserRole, String> implements
	IUserRoleDao {

	@Override
	public List<UserRole> getAllUserRolesById(String roleId) {
		
		return getSqlSession().selectList("userrole.allByRoleId", roleId);
	}

	
}
