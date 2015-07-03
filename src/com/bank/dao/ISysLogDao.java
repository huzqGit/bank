package com.bank.dao;

import java.util.List;

import com.bank.beans.SysLog;
import com.common.dao.GenericDAO;
import com.common.exception.DAOException;

public interface ISysLogDao extends GenericDAO<SysLog, Integer> {
	
//	public List<SysLog> loadAllSysLogs(String operateType, int pageIndex, int pageSize,
//			String sortField, String sortOrder, String startDate, String endDate) throws DAOException;
	
}
