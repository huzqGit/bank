package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerInsured;
import com.bank.dao.IFarmerInsuredDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerInsuredDao")
public class FarmerInsuredDaoImpl extends GenericMyBatisDAOSupport<FarmerInsured, Long>
	implements IFarmerInsuredDao {

}
