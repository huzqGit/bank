package com.bank.dao;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerHouseExample;
import com.common.dao.GenericDAO;

public interface IFarmerHouseDao extends GenericDAO<FarmerHouse, Long> {
	
	public List<FarmerHouse> getHousesByFarmerId(Long farmerId);
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerHouse> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<Farmer> findByFarmers(List<Long> farmerIds);
	public List<FarmerHouse> selectByExample(FarmerHouseExample example);

}
