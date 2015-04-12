package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerCredit;
import com.bank.dao.IFarmerCreditDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerCreditDao")
public class FarmerCreditDaoImpl extends GenericMyBatisDAOSupport<FarmerCredit, Long>
	implements IFarmerCreditDao {

}
