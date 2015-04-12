package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerEvaluate;
import com.bank.dao.IFarmerEvaluateDao;
import com.bank.service.IFarmerEvaluateService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerEvaluateService")
public class FarmerEvaluateServiceImpl extends GenericServiceImpl<FarmerEvaluate, Long> 
	implements IFarmerEvaluateService{
	
	@Resource
	private IFarmerEvaluateDao farmerEvaluateDao;

	@Override
	public GenericDAO<FarmerEvaluate, Long> getGenericDAO() {
		
		return this.farmerEvaluateDao;
	}

}
