package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerPrivateLending;
import com.bank.beans.FarmerPrivateLendingExample;
import com.common.service.GenericService;

public interface IFarmerPrivateLendingService extends GenericService<FarmerPrivateLending, Long> {
	public int findTotalNumber(Long farmerId);
	public List<FarmerPrivateLending> findByPaging(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerPrivateLending> selectByExample(FarmerPrivateLendingExample example);
}
