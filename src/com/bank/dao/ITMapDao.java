package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.vo.TMap;
import com.common.dao.GenericDAO;

public interface ITMapDao extends GenericDAO<TMap, Long>{
	
	public List<Map<String,Object>> getMapTree(Map<String,Object> map);
	
	public Long geMapId(TMap tmap);
	
}
