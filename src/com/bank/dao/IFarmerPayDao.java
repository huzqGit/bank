package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerPay;
import com.common.dao.GenericDAO;

public interface IFarmerPayDao extends GenericDAO<FarmerPay, Long> {
	
	public List<FarmerPay> findByFarmerAndYear(Long farmerId,String year);
	public List<FarmerPay> findByFarmer(Long farmerId);
	public FarmerPay findLatestByFarmer(Long farmerId);
	public List<FarmerPay> findByFarmersAndYear(List<Long> farmerIds,String year);
}
