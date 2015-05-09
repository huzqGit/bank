package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerPay;
import com.bank.dao.IFarmerPayDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerPayDao")
public class FarmerPayDaoImpl extends GenericMyBatisDAOSupport<FarmerPay, Long>
	implements IFarmerPayDao {

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
	public FarmerPay findByFarmer(Long farmerId) {
		FarmerPay balance = this.getSqlSession().selectOne("farmerpay.findByFarmer",farmerId);
		return balance;
	}
	
}
