package com.bank.dao;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerEvaluate;
import com.common.dao.GenericDAO;

public interface IFarmerEvaluateDao extends GenericDAO<FarmerEvaluate, Long> {
	public FarmerEvaluate getEvaluateByFarmerId(Long farmerId);
	public List<Farmer> findByFarmers(List<Long> farmerIds);
	public FarmerEvaluate findByFarmer(Long farmerId);
	public List<FarmerEvaluate> findPagingByFarmerId(int pageIndex,int pageSize,
			String sortField,String sortOrder,Long farmerId);
}
