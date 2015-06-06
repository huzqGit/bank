package com.bank.dao;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerInsured;
import com.common.dao.GenericDAO;

public interface IFarmerInsuredDao extends GenericDAO<FarmerInsured, Long> {
	public List<FarmerInsured> findByFarmerId(Long farmerId);
	public List<Farmer> findByFarmers(List<Long> farmerIds);
	public List<FarmerInsured> findPagingByFarmerId(int pageIndex,int pageSize,
			String sortField,String sortOrder,Long farmerId);
}
