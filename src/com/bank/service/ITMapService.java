package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.vo.TMap;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.GenericService;

public interface ITMapService extends GenericService<TMap, Long>{
	
	public List<Map<String,Object>> getMapTree(Map<String,Object> map);
	
	public void saveSDTMap(String mapkey,String mapValue) throws DAOException, CreateException;
}
