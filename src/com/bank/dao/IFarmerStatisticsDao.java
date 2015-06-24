package com.bank.dao;

import java.util.List;
import java.util.Map;

public interface IFarmerStatisticsDao{
	@SuppressWarnings("rawtypes")
	public List<Map> queryVillages(String dicType);
	public Integer queryTotalFarmer(String vilage);
	public Integer queryLendFarmer(String village);
	public Integer queryBalanceFarmer(String village);
	public Integer queryBadLoanFarmer(String village);
	@SuppressWarnings("rawtypes")
	public List<Map> queryBigLender(String village,int sort);
	@SuppressWarnings("rawtypes")
	public List<Map> queryBigLenderByAmount(String village,int sort);
	@SuppressWarnings("rawtypes")
	public List<Map> queryIncome(String year);
	@SuppressWarnings("rawtypes")
	public List<Map> queryPayment(String year);
	
}
