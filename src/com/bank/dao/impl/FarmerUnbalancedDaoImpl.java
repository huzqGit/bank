package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerUnbalanced;
import com.bank.dao.IFarmerUnbalancedDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerUnbalancedDao")
public class FarmerUnbalancedDaoImpl extends GenericMyBatisDAOSupport<FarmerUnbalanced, Long>
	implements IFarmerUnbalancedDao {

}
