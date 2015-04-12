package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerEnsure;
import com.bank.dao.IFarmerEnsureDao;
import com.bank.service.IFarmerEnsureService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerEnsureService")
public class FarmerEnsureServiceImpl extends GenericServiceImpl<FarmerEnsure, Long> 
	implements IFarmerEnsureService{
	
	@Resource
	private IFarmerEnsureDao farmerEnsureDao;

	@Override
	public GenericDAO<FarmerEnsure, Long> getGenericDAO() {
		
		return this.farmerEnsureDao;
	}

}
