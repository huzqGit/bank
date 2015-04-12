package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerBadloan;
import com.bank.dao.IFarmerBadLoanDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerBadLoanDao")
public class FarmerBadLoanDaoImpl extends GenericMyBatisDAOSupport<FarmerBadloan, Long>
	implements IFarmerBadLoanDao {

}
