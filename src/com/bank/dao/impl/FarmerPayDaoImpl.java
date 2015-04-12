package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerPay;
import com.bank.dao.IFarmerPayDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerPayDao")
public class FarmerPayDaoImpl extends GenericMyBatisDAOSupport<FarmerPay, Long>
	implements IFarmerPayDao {

}
