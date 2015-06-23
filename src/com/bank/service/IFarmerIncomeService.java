package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerIncomeExample;
import com.common.service.GenericService;

public interface IFarmerIncomeService extends
		GenericService<FarmerIncome, Long> {
	public List<FarmerIncome> selectByExample(FarmerIncomeExample example);
}
