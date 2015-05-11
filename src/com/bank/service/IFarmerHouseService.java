package com.bank.service;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerHouseService extends
		GenericService<FarmerHouse, Long> {
	public List<FarmerHouse> findHouseByFarmer(Long farmerId);
	public List<FarmerForest> findForestByFarmer(Long farmerId);
	public List<FarmerBreed> findBreedByFarmer(Long farmerId);
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId);
	public void saveChanQuan(Farmer farmer,List<FarmerHouse> houses,
			List<FarmerForest> forests,List<FarmerBreed> breeds,
			List<FarmerDevice> devices)throws DAOException, CreateException,
			UpdateException, DataNotFoundException ;	

}
