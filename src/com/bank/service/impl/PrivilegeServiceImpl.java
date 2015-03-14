package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Privilege;
import com.bank.dao.IPrivilegeDao;
import com.bank.service.IPrivilegeService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("privilegeService")
public class PrivilegeServiceImpl extends GenericServiceImpl<Privilege, String> implements IPrivilegeService {
	
	@Resource
	private IPrivilegeDao privilegeDao;
	
	@Override
	public GenericDAO<Privilege, String> getGenericDAO() {
		return privilegeDao;
	}
	

}
