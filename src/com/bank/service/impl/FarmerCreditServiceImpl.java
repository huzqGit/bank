package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerCredit;
import com.bank.dao.IFarmerCreditDao;
import com.bank.service.IFarmerCreditService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerCreditService")
public class FarmerCreditServiceImpl extends GenericServiceImpl<FarmerCredit, Long> 
	implements IFarmerCreditService{
	
	@Resource
	private IFarmerCreditDao farmerCreditDao;

	@Override
	public GenericDAO<FarmerCredit, Long> getGenericDAO() {
		
		return this.farmerCreditDao;
	}

}
