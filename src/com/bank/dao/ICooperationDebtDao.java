package com.bank.dao;

import java.util.Map;

import com.bank.beans.FarmerCooperationDebt;
import com.common.dao.GenericDAO;

public interface ICooperationDebtDao extends GenericDAO<FarmerCooperationDebt, Long>{
	
	public long getTotal(Map<String,String> map);
}
