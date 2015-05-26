package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.beans.Apply;
import com.bank.beans.Farmer;
import com.common.dao.GenericDAO;

public interface IFarmerDao extends GenericDAO<Farmer, Long> {
	public void saveApply(Apply apply);
	public List<Apply> findApplyByUser(String userId);
	public List<Farmer> findByFarmerIds(List<Long> farmerIds);
	public Farmer findByID(String farmerIdNum);
	@SuppressWarnings("rawtypes")
	public List<Farmer> findFarmer(Map map);
	public List<Farmer> findByIDAndName(String farmerIdNum,String farmerName);
	public List<Farmer> findByNames(List<String> farmerNames);
}
