package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerForestExample;
import com.common.service.GenericService;

public interface IFarmerForestService extends
		GenericService<FarmerForest, Long> {
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerForest> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerForest> findForestByFarmer(Long farmerId);
	public List<FarmerForest> selectByExample(FarmerForestExample example);
}
