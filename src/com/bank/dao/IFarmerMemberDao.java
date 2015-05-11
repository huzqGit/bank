package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerMember;
import com.common.dao.GenericDAO;

public interface IFarmerMemberDao extends GenericDAO<FarmerMember, Long> {
	
	public List<FarmerMember> getMembersByFarmerId(Long farmerId);

}
