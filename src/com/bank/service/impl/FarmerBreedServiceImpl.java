package com.bank.service.impl;

import java.util.List;

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
	public List<FarmerBreed> findBreedByFarmer(Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerBreed> breeds = farmerBreedDao.getBreedsByFarmerId(farmerId);
		return breeds;
	}

	@Override
	public GenericDAO<FarmerBreed, Long> getGenericDAO() {
		
		return this.farmerBreedDao;
	}

}
