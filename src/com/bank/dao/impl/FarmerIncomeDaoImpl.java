package com.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerIncome;
import com.bank.dao.IFarmerIncomeDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerIncomeDao")
public class FarmerIncomeDaoImpl extends GenericMyBatisDAOSupport<FarmerIncome, Long>
	implements IFarmerIncomeDao {

	@Override
	public List<FarmerIncome> findAll(Long balanceId) {
		List<FarmerIncome> incomes = this.getSqlSession().selectList("farmerincome.findAll",balanceId);
		return incomes;
	}

}
