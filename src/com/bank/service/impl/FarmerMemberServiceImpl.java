package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerMember;
import com.bank.dao.IFarmerMemberDao;
import com.bank.service.IFarmerMemberService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerMemberService")
public class FarmerMemberServiceImpl extends GenericServiceImpl<FarmerMember, Long> 
	implements IFarmerMemberService{
	
	@Resource
	private IFarmerMemberDao farmerMemberDao;

	@Override
	public GenericDAO<FarmerMember, Long> getGenericDAO() {
		
		return this.farmerMemberDao;
	}

}
