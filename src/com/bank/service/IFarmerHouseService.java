package com.bank.service;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerHouseExample;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerHouseService extends
		GenericService<FarmerHouse, Long> {
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerHouse> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerHouse> findHouseByFarmer(Long farmerId);
	public List<FarmerForest> findForestByFarmer(Long farmerId);
	public List<FarmerBreed> findBreedByFarmer(Long farmerId);
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId);
	public  List<Farmer> findByFarmers(List<Long> farmerIds);
	public List<FarmerHouse> selectByExample(FarmerHouseExample example);

}
