package com.bank.service;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerInsuredExample;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerInsuredService extends
		GenericService<FarmerInsured, Long> {
	public int countByExample(FarmerInsuredExample example);
	public List<FarmerInsured> findByFarmer(Long farmerId);
	public void save(Farmer farmer,List<FarmerInsured> insureds)
			throws DAOException, CreateException,UpdateException, 
			DataNotFoundException;
	public List<Farmer> findByFarmers(List<Long> farmerIds);
	public List<FarmerInsured> findPagingByFarmerId(int pageIndex,int pageSize,
			String sortField,String sortOrder,Long farmerId);
	public List<FarmerInsured> selectByExample(FarmerInsuredExample example);
}
