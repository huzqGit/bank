package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerDevice;
import com.bank.dao.IFarmerDeviceDao;
import com.bank.service.IFarmerDeviceService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerDeviceService")
public class FarmerDeviceServiceImpl extends GenericServiceImpl<FarmerDevice, Long> 
	implements IFarmerDeviceService{
	
	@Resource
	private IFarmerDeviceDao farmerDeviceDao;

	@Override
	public GenericDAO<FarmerDevice, Long> getGenericDAO() {
		
		return this.farmerDeviceDao;
	}

}
