package com.bank.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bank.beans.Apply;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerPay;
import com.bank.beans.Loan;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerService extends
		GenericService<Farmer, Long> {
	public void updateBySelective(Farmer farmer);
	@SuppressWarnings("rawtypes")
	public int findTotalNumber(Map paramMap);
	@SuppressWarnings("rawtypes")
	public Map saveFarmer(Farmer farmer,List<FarmerMember> member)
            throws DAOException, UpdateException, DataNotFoundException,
            CreateException;
	public void saveAapply(Apply apply);
	public List<Apply> findApplyByUser(String userId);
	@SuppressWarnings("rawtypes")
	public Map loadFarmer(Long farmerId) throws DAOException, DataNotFoundException ;
	@SuppressWarnings("rawtypes")
	public Map loadTotalFarmer(Long farmerId) throws Exception ;
	public List<Farmer> findByFarmerIds(List<Long> farmerIds);
	public List<Farmer> findPagingByPK(int pageIndex,int pageSize,
			String sortField,String sortOrder,List<Long> farmerIds);
	public List<Farmer>  loadFarmers(Map condition)throws DAOException, DataNotFoundException ;
	public Farmer findById(String idNum,String organId);
	public List<Farmer> findByIDAndName(String farmerIdNum, String farmerName);
	public List<Farmer> findPagingByIDAndName(String pageIndex,String pageSize,
			String sortField,String sortOrder,String farmerIdNum,String farmerName,
			String organId);
	List<Farmer> findByNames(List<String> farmerNames); 
	public List<FarmerMember> findMemberByFarmer(Long farmerId);
	public List<FarmerHouse> findHouseByFarmer(Long farmerId);
	public List<FarmerForest> findForestByFarmer(Long farmerId);
	public List<FarmerBreed> findBreedByFarmer(Long farmerId);
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId);
	public FarmerEvaluate findEvaluateByFarmer(Long farmerId);
	public List<FarmerCompunish> findCompunishByFarmer(Long farmerId);
	public List<Loan> findLoanByFarmer(Long farmerId);
	public List<FarmerPay> findBalanceByFarmer(Long farmerId);
	public FarmerPay findLatestBalanceByFarmer(Long farmerId);
	public List<FarmerInsured> findInsuredByFarmer(Long farmerId);
	public void deleteMembers(List<Long> memberIds);
	@SuppressWarnings("rawtypes")
	public Farmer findSignalByWhereClause(@Param("example")Map param);
	@SuppressWarnings("rawtypes")
	public List<Farmer> findMultiByWhereClause(@Param("example")Map param);
}
