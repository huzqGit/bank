package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerBreed;
import com.bank.dao.IFarmerBreedDao;
import com.bank.service.IFarmerBreedService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerBreedService")
public class FarmerBreedServiceImpl extends GenericServiceImpl<FarmerBreed, Long> 
	implements IFarmerBreedService{
	
	@Resource
	private IFarmerBreedDao farmerBreedDao;

	@Override
	public GenericDAO<FarmerBreed, Long> getGenericDAO() {
		
		return this.farmerBreedDao;
	}

}
