package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerPay;
import com.bank.dao.IFarmerPayDao;
import com.bank.service.IFarmerPayService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerPayService")
public class FarmerPayServiceImpl extends GenericServiceImpl<FarmerPay, Long> 
	implements IFarmerPayService{
	
	@Resource
	private IFarmerPayDao farmerPayDao;

	@Override
	public GenericDAO<FarmerPay, Long> getGenericDAO() {
		
		return this.farmerPayDao;
	}

}
