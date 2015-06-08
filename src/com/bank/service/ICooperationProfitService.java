package com.bank.service;

import java.util.Map;

import com.bank.beans.CooperationProfit;
import com.common.service.GenericService;

public interface ICooperationProfitService extends GenericService<CooperationProfit, Long>{
	
	public long getTotal(Map<String,String> map);
}
