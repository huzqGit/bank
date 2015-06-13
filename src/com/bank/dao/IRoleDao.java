package com.bank.dao;

import java.util.HashMap;
import java.util.List;

import com.bank.beans.Role;
import com.common.dao.GenericDAO;
import com.common.exception.DAOException;

public interface IRoleDao extends GenericDAO<Role, String> {

	void save(HashMap row);

	void update(HashMap row) throws Exception;
	
	List<Role> getRoleTree() throws DAOException;

}
