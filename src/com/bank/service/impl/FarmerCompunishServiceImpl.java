package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerCompunish;
import com.bank.dao.IFarmerCompunishDao;
import com.bank.service.IFarmerCompunishService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerCompunishService")
public class FarmerCompunishServiceImpl extends GenericServiceImpl<FarmerCompunish, Long> 
	implements IFarmerCompunishService{
	
	@Resource
	private IFarmerCompunishDao farmerCompunishDao;

	@Override
	public GenericDAO<FarmerCompunish, Long> getGenericDAO() {
		
		return this.farmerCompunishDao;
	}

}
