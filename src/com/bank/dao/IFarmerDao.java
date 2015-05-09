package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.beans.Farmer;
import com.common.dao.GenericDAO;

public interface IFarmerDao extends GenericDAO<Farmer, Long> {
	
	public Farmer findByID(String farmerIdNum);
	@SuppressWarnings("rawtypes")
	public List<Farmer> findFarmer(Map map);
	public List<Farmer> findByIDAndName(String farmerIdNum,String farmerName);
	public List<Farmer> findByNames(List<String> farmerNames);
}
