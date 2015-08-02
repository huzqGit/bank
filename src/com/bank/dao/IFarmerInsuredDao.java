package com.bank.dao;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerInsuredExample;
import com.common.dao.GenericDAO;

public interface IFarmerInsuredDao extends GenericDAO<FarmerInsured, Long> {
	public int countByExample(FarmerInsuredExample example);
	public List<FarmerInsured> findByFarmerId(Long farmerId);
	public List<Farmer> findByFarmers(List<Long> farmerIds);
	public List<FarmerInsured> findPagingByFarmerId(int pageIndex,int pageSize,
			String sortField,String sortOrder,Long farmerId);
	public List<FarmerInsured> selectByExample(FarmerInsuredExample example);
}
