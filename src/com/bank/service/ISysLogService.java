package com.bank.service;

import java.util.List;

import com.bank.beans.SysLog;
import com.bank.beans.User;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.GenericService;

public interface ISysLogService extends GenericService<SysLog, Integer> {
	
	public void addLog(String LogContent, int loglevel,int operatetype, User user) throws DAOException,CreateException;
	
	public List<SysLog> loadAllSysLogs(String operateType, int pageIndex, int pageSize,
			String sortField, String sortOrder, String startDate, String endDate) throws DAOException;

}
