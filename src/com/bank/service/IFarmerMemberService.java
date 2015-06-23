package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerMemberExample;
import com.common.service.GenericService;

public interface IFarmerMemberService extends
		GenericService<FarmerMember, Long> {
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerMember> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerMember> selectByExample(FarmerMemberExample example);
}
