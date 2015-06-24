package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerPrivateLendingExample;
import com.bank.beans.FarmerPrivateLending;
import com.common.dao.GenericDAO;

public interface IFarmerPrivateLendingDao extends GenericDAO<FarmerPrivateLending,Long>{
	
	public int findTotalNumber(Long farmerId);
	public List<FarmerPrivateLending> findByPaging(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerPrivateLending> selectByExample(FarmerPrivateLendingExample example);

}
