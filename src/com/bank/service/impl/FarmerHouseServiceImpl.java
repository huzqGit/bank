package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerHouse;
import com.bank.dao.IFarmerHouseDao;
import com.bank.service.IFarmerHouseService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerHouseService")
public class FarmerHouseServiceImpl extends GenericServiceImpl<FarmerHouse, Long> 
	implements IFarmerHouseService{
	
	@Resource
	private IFarmerHouseDao farmerHouseDao;

	@Override
	public GenericDAO<FarmerHouse, Long> getGenericDAO() {
		
		return this.farmerHouseDao;
	}

}
