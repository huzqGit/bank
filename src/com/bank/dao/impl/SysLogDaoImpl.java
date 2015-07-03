package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.SysLog;
import com.bank.beans.User;
import com.bank.dao.ISysLogDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("sysLogDao")
public class SysLogDaoImpl extends GenericMyBatisDAOSupport<SysLog, Integer> implements
		ISysLogDao {
	
//	public List<SysLog> loadAllSysLogs(String operateType, int pageIndex, int pageSize, 
//			String sortField, String sortOrder, String startDate, String endDate) {
//		Map<String, Object> map = new HashMap();
//		int start = pageIndex * pageSize, end = start + pageSize;
//		if ("desc".equals(sortOrder) == false) sortOrder = "asc";
//		map.put("start", start);
//		map.put("end", end);
//		map.put("sortOrder", sortOrder);
//		map.put("sortField", sortField);
//		map.put("operateType", operateType);
//		map.put("startDate", startDate);
//		map.put("endDate", endDate);
//		return getSqlSession().selectList("sysLog.loadAllSysLog", map);
//	}

}
