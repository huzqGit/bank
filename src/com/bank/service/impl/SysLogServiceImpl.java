package com.bank.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bank.beans.SysLog;
import com.bank.beans.User;
import com.bank.dao.ISysLogDao;
import com.bank.service.ISysLogService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.impl.GenericServiceImpl;
import com.common.tools.BrowserUtils;
import com.common.tools.ContextHolderUtils;
import com.common.tools.IpUtil;

@Service("sysLogSerivce")
public class SysLogServiceImpl extends GenericServiceImpl<SysLog, Integer> implements ISysLogService {
	private static Logger log = LoggerFactory.getLogger(SysLogServiceImpl.class);
	
	@Resource
	private ISysLogDao sysLogDao;
	
	public GenericDAO<SysLog, Integer> getGenericDAO() {
		return sysLogDao;
	}

	public void addLog(String logContent, int logLevel, int operateType, User user)
			throws DAOException, CreateException {
		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.checkBrowse(request);
		SysLog sysLog = new SysLog();
		sysLog.setLogContent(logContent);
		sysLog.setLogLevel(logLevel);
		sysLog.setOperateType(operateType);
		sysLog.setNote(IpUtil.getIp());
		sysLog.setBroswer(broswer);
		sysLog.setOperateTime(new Timestamp(System.currentTimeMillis()));
		sysLog.setUserId(user.getUserId());
		sysLog.setUserName(user.getUserName());
		sysLogDao.save(sysLog);
	}

	public List<SysLog> loadAllSysLogs(String operateType, int pageIndex,
			int pageSize, String sortField, String sortOrder, String startDate,
			String endDate) throws DAOException {
		Map paramMap = new HashMap();
		paramMap.put("operateType", operateType);
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		return sysLogDao.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
	}
}
