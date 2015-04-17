package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerBadLoan;
import com.bank.dao.IFarmerBadLoanDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerBadLoanDao")
public class FarmerBadLoanDaoImpl extends GenericMyBatisDAOSupport<FarmerBadLoan, Long>
	implements IFarmerBadLoanDao {

}
