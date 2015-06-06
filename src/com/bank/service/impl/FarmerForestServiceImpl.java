package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerForest;
import com.bank.dao.IFarmerForestDao;
import com.bank.service.IFarmerForestService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerForestService")
public class FarmerForestServiceImpl extends GenericServiceImpl<FarmerForest, Long> 
	implements IFarmerForestService{
	
	@Resource
	private IFarmerForestDao farmerForestDao;


	@Override
	public List<FarmerForest> findForestByFarmer(Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerForest> forests = farmerForestDao.getForestsByFarmerId(farmerId);
		return forests;
	}


	@Override
	public GenericDAO<FarmerForest, Long> getGenericDAO() {
		
		return this.farmerForestDao;
	}
	
}
