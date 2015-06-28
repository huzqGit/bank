package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.vo.TMap;
import com.common.service.GenericService;

public interface ITMapService extends GenericService<TMap, Long>{
	
	public List<Map<String,Object>> getMapTree(Map<String,Object> map);
}
