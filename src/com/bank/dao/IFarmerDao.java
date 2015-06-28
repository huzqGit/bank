package com.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bank.beans.Apply;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerExample;
import com.common.dao.GenericDAO;

public interface IFarmerDao extends GenericDAO<Farmer, Long> {
	public void updateBySelective(Farmer farmer);
	@SuppressWarnings("rawtypes")
	public int findTotalNumber(Map paramMap);
	public void saveApply(Apply apply);
	public List<Apply> findApplyByUser(String userId);
	public List<Farmer> findByFarmerIds(List<Long> farmerIds);
	public List<Farmer> findPagingByPK(int pageIndex, int pageSize,
			String sortField, String sortOrder, List<Long> farmerIds);
	public Farmer findByID(String farmerIdNum,String organId);
	@SuppressWarnings("rawtypes")
	public List<Farmer> findFarmer(Map map);
	public List<Farmer> findByIDAndName(String farmerIdNum,String farmerName);
	public List<Farmer> findPagingByIDAndName(String pageIndex,String pageSize,
			String sortField,String sortOrder,String farmerIdNum,String farmerName,
			String organId);
	public List<Farmer> findByNames(List<String> farmerNames);
	@SuppressWarnings("rawtypes")
	public Farmer findSignalByWhereClause(@Param("example")Map param);
	@SuppressWarnings("rawtypes")
	public List<Farmer> findMultiByWhereClause(@Param("example")Map param);
	public List<Farmer> selectByExample(FarmerExample example);
	public List<Farmer> selectSignalByExample(FarmerExample example);
}
