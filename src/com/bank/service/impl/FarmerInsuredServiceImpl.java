package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerInsured;
import com.bank.dao.IFarmerInsuredDao;
import com.bank.service.IFarmerInsuredService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerInsuredService")
public class FarmerInsuredServiceImpl extends GenericServiceImpl<FarmerInsured, Long> 
	implements IFarmerInsuredService{
	
	@Resource
	private IFarmerInsuredDao farmerInsuredDao;

	@Override
	public GenericDAO<FarmerInsured, Long> getGenericDAO() {
		
		return this.farmerInsuredDao;
	}

}
