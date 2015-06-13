package com.bank.service;

import java.util.HashMap;
import java.util.List;

import com.bank.beans.Role;
import com.common.exception.DAOException;
import com.common.service.GenericService;

public interface IRoleService extends GenericService<Role, String> {

	void save(HashMap row);

	void update(HashMap row) throws Exception;
	
	List<Role> getRoleTree() throws DAOException;

}
