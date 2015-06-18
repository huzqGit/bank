package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerForest;
import com.common.dao.GenericDAO;

public interface IFarmerForestDao extends GenericDAO<FarmerForest, Long> {
	
	public List<FarmerForest> getForestsByFarmerId(Long farmerId);
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerForest> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
}
