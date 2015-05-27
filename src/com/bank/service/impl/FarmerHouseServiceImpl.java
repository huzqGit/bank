package com.bank.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;







import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
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
	public void saveChanQuan(Farmer farmer, List<FarmerHouse> houses,
			List<FarmerForest> forests, List<FarmerBreed> breeds,
			List<FarmerDevice> devices) throws DAOException, CreateException,
			UpdateException, DataNotFoundException {
		if(farmer.getId() == null){
			return ;
		}else{
			for(Iterator<FarmerHouse> it = houses.iterator();it.hasNext();){
				FarmerHouse house = it.next();
				if(house.getFarmerId() == null){
					house.setFarmerId(farmer.getId());
				}
				if(house.getId() == null){
					farmerHouseDao.save(house);
				}else{
					farmerHouseDao.update(house);
				}
			}
			for(Iterator<FarmerForest> it = forests.iterator();it.hasNext();){
				FarmerForest forest = it.next();
				if(forest.getFarmerId() == null){
					forest.setFarmerId(farmer.getId());
				}
				if(forest.getId() == null){
					farmerForestDao.save(forest);
				}else{
					farmerForestDao.update(forest);
				}
			}
			for(Iterator<FarmerBreed> it = breeds.iterator();it.hasNext();){
				FarmerBreed breed = it.next();
				if(breed.getFarmerId() == null){
					breed.setFarmerId(farmer.getId());
				}
				if(breed.getId() == null){
					farmerBreedDao.save(breed);
				}else{
					farmerBreedDao.update(breed);
				}
			}
			for(Iterator<FarmerDevice> it = devices.iterator();it.hasNext();){
				FarmerDevice device = it.next();
				if(device.getFarmerId() == null){
					device.setFarmerId(farmer.getId());
				}
				if(device.getId() == null){
					farmerDeviceDao.save(device);
				}else{
					farmerDeviceDao.update(device);
				}
			}
		}
	}

	@Override
	public List<Farmer> findByFarmers(List<Long> farmerIds) {
		List<Farmer> farmers =  farmerHouseDao.findByFarmers(farmerIds);
		return farmers;
	}
	
}
