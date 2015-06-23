package com.bank.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerPay;
import com.bank.beans.FarmerPayExample;
import com.bank.dao.IFarmerDao;
import com.bank.dao.IFarmerIncomeDao;
import com.bank.dao.IFarmerPayDao;
import com.bank.service.IFarmerPayService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerPayService")
public class FarmerPayServiceImpl extends GenericServiceImpl<FarmerPay, Long> 
	implements IFarmerPayService{
	
	@Resource
	private IFarmerDao farmerDao;
	@Resource
	private IFarmerPayDao farmerPayDao;
	@Resource
	private IFarmerIncomeDao farmerIncomeDao;
	@Override
	public GenericDAO<FarmerPay, Long> getGenericDAO() {
		
		return this.farmerPayDao;
	}
	
	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = farmerPayDao.findTotalNumberByFarmerId(farmerId);
		return totalNumber;
	}

	@Override
	public List<FarmerPay> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerPay> balances = farmerPayDao.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return balances;
	}

	@Override
	public void saveBalance(Farmer farmer,FarmerPay balance, List<FarmerIncome> incomes) 
				throws DAOException, DataNotFoundException, 
				CreateException, UpdateException {
		
		if(balance == null ||balance.getYear() == null){
		//保存时年度收支信息不能为空
			return ;
		}
		balance.setFarmerid(farmer.getId());
		if(balance.getId() == null){
			farmerPayDao.save(balance);
		}else{
			farmerPayDao.update(balance);
		}
		for(Iterator<FarmerIncome> it = incomes.iterator();it.hasNext();){
			FarmerIncome income = it.next();
			income.setPayid(balance.getId());
			if(income.getId() == null){
				farmerIncomeDao.save(income);
			}else{
				farmerIncomeDao.update(income);
			}
		}
	}
	
	@Override
	public List<FarmerPay> loadPayByDateAndFarmer(Long farmerId, String year) {
		List<FarmerPay> balances = farmerPayDao.findByFarmerAndYear(farmerId, year);
		return balances;
	}

	@Override
	public List<FarmerIncome> loadTotalIncome(Long balanceId) {
		List<FarmerIncome> incomes =farmerIncomeDao.findAll(balanceId);
		return incomes;
	}

	@Override
	public List<FarmerPay> findByFarmerAndYear(Long farmerId,String year) {
		List<FarmerPay> balances = farmerPayDao.findByFarmerAndYear(farmerId, year);
		return balances;
	}
	@Override
	public List<FarmerPay> findByFarmersAndYear(List<Long> farmerIds,
			String year) {
		List<FarmerPay> balances = farmerPayDao.findByFarmersAndYear(farmerIds, year);
		return balances;
	}
	@Override
	public void deleteIncomes(List<Long> incomes) {
		// TODO Auto-generated method stub
		farmerPayDao.deleteIncomes(incomes);
	}

	@Override
	public List<FarmerPay> selectByExample(FarmerPayExample example) {
		// TODO Auto-generated method stub
		List<FarmerPay> balances = farmerPayDao.selectByExample(example);
		return balances;
	}

	
}
