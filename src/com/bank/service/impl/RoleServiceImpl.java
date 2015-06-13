package com.bank.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bank.beans.Role;
import com.bank.dao.IRoleDao;
import com.bank.service.IRoleService;
import com.common.dao.GenericDAO;
import com.common.exception.DAOException;
import com.common.service.impl.GenericServiceImpl;

@Service("roleSerivce")
public class RoleServiceImpl extends GenericServiceImpl<Role, String> implements
		IRoleService {
	private static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Resource
	private IRoleDao roleDao;
	
	public GenericDAO<Role, String> getGenericDAO() {
		return roleDao;
	}

	@Override
	public void save(HashMap row) {
		roleDao.save(row);
	}

	@Override
	public void update(HashMap row) throws Exception {
		roleDao.update(row);
	}
	
	public List<Role> getRoleTree() throws DAOException {
		return roleDao.getRoleTree();
	}
}
