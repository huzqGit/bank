package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.Role;
import com.bank.dao.IRoleDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("roleDao")
public class RoleDaoImpl extends GenericMyBatisDAOSupport<Role, String> implements
		IRoleDao {


}
