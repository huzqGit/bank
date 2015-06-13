package com.bank.service;

import java.util.List;

import com.bank.beans.UserRole;
import com.common.service.GenericService;

public interface IUserRoleService extends GenericService<UserRole, String> {

	List<UserRole> getAllUserRolesById(String roleId);


}
