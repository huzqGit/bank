package com.bank.service;

import java.util.List;
import java.util.Map;

public interface IFarmerStatisticsService {

	public List<Map<String,String>> queryFarmerNum();
	@SuppressWarnings("rawtypes")
	public List<Map> queryBigLender(String village,String type,int no); 
	@SuppressWarnings("rawtypes")
	public List<Map> queryIncome(String year);
	@SuppressWarnings("rawtypes")
	public List<Map> queryPayment(String year);
	
}
