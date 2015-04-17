package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerBadLoan;
import com.bank.dao.IFarmerBadLoanDao;
import com.bank.service.IFarmerBadLoanService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerBadLoanService")
public class FarmerBadLoanServiceImpl extends GenericServiceImpl<FarmerBadLoan, Long> 
	implements IFarmerBadLoanService{
	
	@Resource
	private IFarmerBadLoanDao farmerBadLoanDao;

	@Override
	public GenericDAO<FarmerBadLoan, Long> getGenericDAO() {
		
		return this.farmerBadLoanDao;
	}

}
