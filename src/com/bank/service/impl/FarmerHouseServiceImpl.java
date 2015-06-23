package com.bank.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerHouseExample;
import com.bank.dao.IFarmerBreedDao;
import com.bank.dao.IFarmerDeviceDao;
import com.bank.dao.IFarmerForestDao;
import com.bank.dao.IFarmerHouseDao;
import com.bank.service.IFarmerHouseService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerHouseService")
public class FarmerHouseServiceImpl extends GenericServiceImpl<FarmerHouse, Long> 
	implements IFarmerHouseService{
	
	@Resource
	private IFarmerHouseDao farmerHouseDao;
	@Resource
	private IFarmerForestDao farmerForestDao;
	@Resource
	private IFarmerBreedDao farmerBreedDao;
	@Resource
	private IFarmerDeviceDao farmerDeviceDao;

	@Override
	public GenericDAO<FarmerHouse, Long> getGenericDAO() {
		
		return this.farmerHouseDao;
	}

	@Override
	public List<FarmerHouse> findHouseByFarmer(Long farmerId) {
		List<FarmerHouse> houses = farmerHouseDao.getHousesByFarmerId(farmerId);
		return houses;
	}
	

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = farmerHouseDao.findTotalNumberByFarmerId(farmerId);
		return totalNumber;
	}

	@Override
	public List<FarmerHouse> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerHouse> houses = farmerHouseDao.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return houses;
	}

	@Override
	public List<FarmerForest> findForestByFarmer(Long farmerId) {
		List<FarmerForest> forests = farmerForestDao.getForestsByFarmerId(farmerId);
		return forests;
	}

	@Override
	public List<FarmerBreed> findBreedByFarmer(Long farmerId) {
		List<FarmerBreed> breeds = farmerBreedDao.getBreedsByFarmerId(farmerId);
		return breeds;
	}

	@Override
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId) {
		List<FarmerDevice> devices = farmerDeviceDao.getDevicesByFarmerId(farmerId);
		return devices;
	}

	@Override
	public List<Farmer> findByFarmers(List<Long> farmerIds) {
		List<Farmer> farmers =  farmerHouseDao.findByFarmers(farmerIds);
		return farmers;
	}

	@Override
	public List<FarmerHouse> selectByExample(FarmerHouseExample example) {
		// TODO Auto-generated method stub
		List<FarmerHouse> houses = farmerHouseDao.selectByExample(example);
		return houses;
	}
	
}
