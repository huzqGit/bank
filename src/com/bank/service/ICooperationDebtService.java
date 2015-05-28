package com.bank.service;

import java.util.Map;

import com.bank.beans.FarmerCooperationDebt;
import com.common.service.GenericService;

public interface ICooperationDebtService extends GenericService<FarmerCooperationDebt, Long>{
	
	public long getTotal(Map<String,String> map);
}
