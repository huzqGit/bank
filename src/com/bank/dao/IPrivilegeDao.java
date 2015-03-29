package com.bank.dao;

import java.util.HashMap;

import com.bank.beans.Privilege;
import com.common.dao.GenericDAO;

public interface IPrivilegeDao extends GenericDAO<Privilege, String> {

	void save(HashMap row);

	void update(HashMap row) throws Exception;

}
