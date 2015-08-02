package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerPay;
import com.bank.beans.FarmerPayExample;
import com.bank.dao.IFarmerPayDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerPayDao")
public class FarmerPayDaoImpl extends GenericMyBatisDAOSupport<FarmerPay, Long>
	implements IFarmerPayDao {

	@Override
	public int countByExample(FarmerPayExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne("farmerpay.countByExample", example);
		return num;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerPay> findByFarmerAndYear(Long farmerId,String year) {
		Map map = new HashMap();
		map.put("farmerId", farmerId);
		map.put("year", year);
		List<FarmerPay> balances = this.getSqlSession().selectList("farmerpay.findByFarmerAndYear",map);
		return balances;
	}

	@Override
	public List<FarmerPay> findByFarmer(Long farmerId) {
		List<FarmerPay> balances = this.getSqlSession().selectList("farmerpay.findByFarmer",farmerId);
		return balances;
	}

	@Override
	public FarmerPay findLatestByFarmer(Long farmerId) {
		FarmerPay balance = this.getSqlSession().selectOne("farmerpay.findLatestByFarmer",farmerId);
		return balance;
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = this.getSqlSession().selectOne("farmerpay.findTotalNumberByFarmerId",farmerId);
		return totalNumber;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<FarmerPay> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		map.put("start",start+1);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.put("farmerId", farmerId);
		List<FarmerPay> balances = this.getSqlSession().selectList("farmerpay.findPagingByFarmerId",map);
		return balances;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<FarmerPay> findByFarmersAndYear(List<Long> farmerIds,
			String year) {
		Map map = new HashMap();
		map.put("farmerIds",farmerIds);
		map.put("year", year);
		List<FarmerPay> balances = this.getSqlSession().selectList("farmerpay.findByFarmersAndYear", map);
		return balances;
	}

	@Override
	public void deleteIncomes(List<Long> incomes) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("farmerincome.delete",incomes);
	}

	@Override
	public List<FarmerPay> selectByExample(FarmerPayExample example) {
		// TODO Auto-generated method stub
		List<FarmerPay> balances = this.getSqlSession().selectList("farmerpay.selectByExample",example);
		return balances;
	}
	
}
