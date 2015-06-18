package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerPrivateLending;
import com.common.service.GenericService;

public interface IFarmerPrivateLendingService extends GenericService<FarmerPrivateLending, Long> {
	public int findTotalNumber(Long farmerId);
	public List<FarmerPrivateLending> findByPaging(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
}
