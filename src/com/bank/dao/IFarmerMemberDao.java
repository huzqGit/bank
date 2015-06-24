package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerMemberExample;
import com.common.dao.GenericDAO;

public interface IFarmerMemberDao extends GenericDAO<FarmerMember, Long> {
	
	public List<FarmerMember> getMembersByFarmerId(Long farmerId);
	public void deleteMembers(List<Long> memberIds);
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerMember> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerMember> selectByExample(FarmerMemberExample example);
}
