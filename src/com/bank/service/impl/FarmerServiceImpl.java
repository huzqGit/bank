package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.dao.IFarmerDao;
import com.bank.service.IFarmerService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerService")
public class FarmerServiceImpl extends GenericServiceImpl<Farmer, Long> 
	implements IFarmerService{
	
	@Resource
	private IFarmerDao farmerDao;

	@Override
	public GenericDAO<Farmer, Long> getGenericDAO() {
		
		return this.farmerDao;
	}

}
