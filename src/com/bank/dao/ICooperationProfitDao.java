package com.bank.dao;

import java.util.Map;

import com.bank.beans.CooperationProfit;
import com.common.dao.GenericDAO;

public interface ICooperationProfitDao extends GenericDAO<CooperationProfit, Long>{
	
	public long getTotal(Map<String,String> map);
	public Long getUnitId(Map<String,Object> map);
}
