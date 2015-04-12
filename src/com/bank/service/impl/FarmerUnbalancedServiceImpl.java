package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerUnbalanced;
import com.bank.dao.IFarmerUnbalancedDao;
import com.bank.service.IFarmerUnbalancedService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerUnbalancedService")
public class FarmerUnbalancedServiceImpl extends GenericServiceImpl<FarmerUnbalanced, Long> 
	implements IFarmerUnbalancedService{
	
	@Resource
	private IFarmerUnbalancedDao farmerUnbalancedDao;

	@Override
	public GenericDAO<FarmerUnbalanced, Long> getGenericDAO() {
		
		return this.farmerUnbalancedDao;
	}

}
