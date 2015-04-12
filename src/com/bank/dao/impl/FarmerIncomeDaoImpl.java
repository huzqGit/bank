package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerIncome;
import com.bank.dao.IFarmerIncomeDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerIncomeDao")
public class FarmerIncomeDaoImpl extends GenericMyBatisDAOSupport<FarmerIncome, Long>
	implements IFarmerIncomeDao {

}
