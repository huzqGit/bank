package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerIncome;
import com.bank.dao.IFarmerIncomeDao;
import com.bank.service.IFarmerIncomeService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerIncomeService")
public class FarmerIncomeServiceImpl extends GenericServiceImpl<FarmerIncome, Long> 
	implements IFarmerIncomeService{
	
	@Resource
	private IFarmerIncomeDao farmerIncomeDao;

	@Override
	public GenericDAO<FarmerIncome, Long> getGenericDAO() {
		
		return this.farmerIncomeDao;
	}

}
