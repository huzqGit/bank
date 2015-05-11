package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerPay;
import com.common.dao.GenericDAO;

public interface IFarmerPayDao extends GenericDAO<FarmerPay, Long> {
	
	public List<FarmerPay> findByFarmerAndYear(Long farmerId,String year);
	public FarmerPay findByFarmer(Long farmerId);

}
