package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.Privilege;
import com.bank.dao.IPrivilegeDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends GenericMyBatisDAOSupport<Privilege, String> implements
		IPrivilegeDao {


}
