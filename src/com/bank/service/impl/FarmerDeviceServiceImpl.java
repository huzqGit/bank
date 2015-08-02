package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerDeviceExample;
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
	public int countByExample(FarmerDeviceExample example) {
		// TODO Auto-generated method stub
		return farmerDeviceDao.countByExample(example);
	}

	@Override
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerDevice> devices = farmerDeviceDao.getDevicesByFarmerId(farmerId);
		return devices;
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = farmerDeviceDao.findTotalNumberByFarmerId(farmerId);
		return totalNumber;
	}

	@Override
	public List<FarmerDevice> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerDevice> devices = farmerDeviceDao.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return devices;
	}

	@Override
	public GenericDAO<FarmerDevice, Long> getGenericDAO() {
		
		return this.farmerDeviceDao;
	}

	@Override
	public List<FarmerDevice> selectByExample(FarmerDeviceExample example) {
		// TODO Auto-generated method stub
		List<FarmerDevice> devices = farmerDeviceDao.selectByExample(example);
		return devices;
	}
	

}
