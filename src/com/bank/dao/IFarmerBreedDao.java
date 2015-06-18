package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerBreed;
import com.common.dao.GenericDAO;

public interface IFarmerBreedDao extends GenericDAO<FarmerBreed, Long> {
	public List<FarmerBreed> getBreedsByFarmerId(Long farmerId);
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerBreed> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);

}
