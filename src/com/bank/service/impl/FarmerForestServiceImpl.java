package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerForestExample;
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
	public int countByExample(FarmerForestExample example) {
		// TODO Auto-generated method stub
		return farmerForestDao.countByExample(example);
	}


	@Override
	public List<FarmerForest> findForestByFarmer(Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerForest> forests = farmerForestDao.getForestsByFarmerId(farmerId);
		return forests;
	}


	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = farmerForestDao.findTotalNumberByFarmerId(farmerId);
		return totalNumber;
	}


	@Override
	public List<FarmerForest> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerForest> devices = farmerForestDao.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return devices;
	}


	@Override
	public GenericDAO<FarmerForest, Long> getGenericDAO() {
		
		return this.farmerForestDao;
	}


	@Override
	public List<FarmerForest> selectByExample(FarmerForestExample example) {
		// TODO Auto-generated method stub
		List<FarmerForest> forests = farmerForestDao.selectByExample(example);
		return forests;
	}
	
}
