package com.bank.service;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerEvaluate;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerEvaluateService extends
		GenericService<FarmerEvaluate, Long> {
	public void saveEvaluate(Farmer farmer,FarmerEvaluate evaluate)throws DAOException, 
			CreateException, UpdateException, DataNotFoundException;
	public FarmerEvaluate getEvaluateByFarmer(Long farmerId);
	public List<Farmer> findByFarmers(List<Long> farmerIds);
	public FarmerEvaluate findByID(Long farmerId);
	public List<FarmerEvaluate> findPagingByFarmerId(int pageIndex,int pageSize,
			String sortField,String sortOrder,Long farmerId);
}
