package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerMemberExample;
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
	
	@Override
	public int countByExample(FarmerMemberExample example) {
		// TODO Auto-generated method stub
		return farmerMemberDao.countByExample(example);
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = farmerMemberDao.findTotalNumberByFarmerId(farmerId);
		return totalNumber;
	}

	@Override
	public List<FarmerMember> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerMember> members = farmerMemberDao.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return members;
	}

	@Override
	public List<FarmerMember> selectByExample(FarmerMemberExample example) {
		// TODO Auto-generated method stub
		List<FarmerMember> members = farmerMemberDao.selectByExample(example);
		return members;
	}
	

}
