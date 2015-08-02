package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerCompunishExample;
import com.common.dao.GenericDAO;

public interface IFarmerCompunishDao extends GenericDAO<FarmerCompunish, Long> {
	
	public int countByExample(FarmerCompunishExample example);
	public List<FarmerCompunish> getCompunishByFarmerId(Long farmerId);
	public List<FarmerCompunish> findByFarmers(List<Long> farmerIds);
	public List<FarmerCompunish> findPagingByFarmerId(int pageIndex,int pageSize,
			String sortField,String sortOrder,Long farmerId);
	public List<FarmerCompunish> selectByExample(FarmerCompunishExample example);
}
