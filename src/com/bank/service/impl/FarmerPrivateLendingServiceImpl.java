package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerPrivateLending;
import com.bank.beans.FarmerPrivateLendingExample;
import com.bank.dao.IFarmerPrivateLendingDao;
import com.bank.service.IFarmerPrivateLendingService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerPrivateLendingService")
public class FarmerPrivateLendingServiceImpl extends GenericServiceImpl<FarmerPrivateLending, Long>
		implements IFarmerPrivateLendingService {
	
	@Resource
	private IFarmerPrivateLendingDao farmerPrivateLendingDao;
	
	@Override
	public GenericDAO<FarmerPrivateLending, Long> getGenericDAO() {
		// TODO Auto-generated method stub
		return farmerPrivateLendingDao;
	}

	@Override
	public int findTotalNumber(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = farmerPrivateLendingDao.findTotalNumber(farmerId);
		return totalNumber;
	}

	@Override
	public List<FarmerPrivateLending> findByPaging(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerPrivateLending> lendings = farmerPrivateLendingDao.findByPaging(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return lendings;
	}

	@Override
	public List<FarmerPrivateLending> selectByExample(
			FarmerPrivateLendingExample example) {
		// TODO Auto-generated method stub
		List<FarmerPrivateLending> lendings = farmerPrivateLendingDao.selectByExample(example);
		return lendings;
	}


}
