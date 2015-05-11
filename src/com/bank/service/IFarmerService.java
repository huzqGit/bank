package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerMember;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerService extends
		GenericService<Farmer, Long> {
	@SuppressWarnings("rawtypes")
	public Map saveFarmer(Farmer farmer,List<FarmerMember> member)
            throws DAOException, UpdateException, DataNotFoundException,
            CreateException;
	
	@SuppressWarnings("rawtypes")
	public Map loadFarmer(Long farmerId) throws DAOException, DataNotFoundException ;
	
	public List<Farmer>  loadFarmers(Map condition)throws DAOException, DataNotFoundException ;
	public Farmer findById(String idNum);
	public List<Farmer> findByIDAndName(String farmerIdNum, String farmerName);
	List<Farmer> findByNames(List<String> farmerNames); 

}
