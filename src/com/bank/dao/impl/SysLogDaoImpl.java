package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.SysLog;
import com.bank.dao.ISysLogDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("sysLogDao")
public class SysLogDaoImpl extends GenericMyBatisDAOSupport<SysLog, Integer> implements
		ISysLogDao {


}
