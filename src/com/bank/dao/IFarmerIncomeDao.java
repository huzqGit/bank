package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerIncome;
import com.common.dao.GenericDAO;

public interface IFarmerIncomeDao extends GenericDAO<FarmerIncome, Long> {
	
	public List<FarmerIncome> findAll(Long balanceId);

}
