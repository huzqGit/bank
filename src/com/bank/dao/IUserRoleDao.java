package com.bank.dao;

import java.util.List;

import com.bank.beans.UserRole;
import com.common.dao.GenericDAO;

public interface IUserRoleDao extends GenericDAO<UserRole, String> {

	List<UserRole> getAllUserRolesById(String roleId);

}
