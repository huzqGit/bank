package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;






import com.bank.beans.FarmerCredit;
import com.bank.beans.FarmerCreditExample;
import com.bank.dao.IFarmerCreditDao;
import com.bank.service.IFarmerCreditService;

@Service("farmerCreditService")
public class FarmerCreditServiceImpl implements IFarmerCreditService{
	
	@Resource
	private IFarmerCreditDao farmerCreditDao;

	@Override
	public int countByExample(FarmerCreditExample example) {
		// TODO Auto-generated method stub
		return farmerCreditDao.countByExample(example);
	}

	@Override
	public int deleteByExample(FarmerCreditExample example) {
		// TODO Auto-generated method stub
		return farmerCreditDao.deleteByExample(example);
	}

	@Override
	public int insert(FarmerCredit record) {
		// TODO Auto-generated method stub
		return farmerCreditDao.insert(record);
	}

	@Override
	public int insertSelective(FarmerCredit record) {
		// TODO Auto-generated method stub
		return farmerCreditDao.insertSelective(record);
	}

	@Override
	public List<FarmerCredit> selectByExample(FarmerCreditExample example) {
		// TODO Auto-generated method stub
		return farmerCreditDao.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(FarmerCredit record,
			FarmerCreditExample example) {
		// TODO Auto-generated method stub
		return farmerCreditDao.updateByExample(record, example);
	}

	@Override
	public int updateByExample(FarmerCredit record, FarmerCreditExample example) {
		// TODO Auto-generated method stub
		return farmerCreditDao.updateByExample(record, example);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<FarmerCredit> getPageingEntities(int pageIndex, int pageSize,
			String sortField, String sortOrder, Map query) {
		// TODO Auto-generated method stub
		return farmerCreditDao.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	}

}
