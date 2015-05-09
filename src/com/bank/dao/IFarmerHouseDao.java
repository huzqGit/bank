package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerHouse;
import com.common.dao.GenericDAO;

public interface IFarmerHouseDao extends GenericDAO<FarmerHouse, Long> {
	
	public List<FarmerHouse> getHousesByFarmerId(Long farmerId);

}
