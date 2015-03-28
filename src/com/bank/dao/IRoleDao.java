package com.bank.dao;

import java.util.HashMap;

import com.bank.beans.Role;
import com.common.dao.GenericDAO;

public interface IRoleDao extends GenericDAO<Role, String> {

	void save(HashMap row);

	void update(HashMap row) throws Exception;

}
