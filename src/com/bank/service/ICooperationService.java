package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.FarmerCooperation;
import com.common.service.GenericService;

public interface ICooperationService extends GenericService<FarmerCooperation, Long>{
	
	public long getTotal(Map<String,String> map);
	
	public List<Map<String,Object>> getCooperationTree(Map<String,Object> map);
}
