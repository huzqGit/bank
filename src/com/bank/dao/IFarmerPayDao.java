package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerPay;
import com.bank.beans.FarmerPayExample;
import com.common.dao.GenericDAO;

public interface IFarmerPayDao extends GenericDAO<FarmerPay, Long> {
	
	public int countByExample(FarmerPayExample example);
	public List<FarmerPay> findByFarmerAndYear(Long farmerId,String year);
	public List<FarmerPay> findByFarmer(Long farmerId);
	public List<FarmerPay> findLatestByFarmer(String farmeridnum);
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerPay> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerPay> findByFarmersAndYear(List<Long> farmerIds,String year);
	public void deleteIncomes(List<Long> incomes);
	public List<FarmerPay> selectByExample(FarmerPayExample example);
}
