package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerForest;
import com.bank.dao.IFarmerForestDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerForestDao")
public class FarmerForestDaoImpl extends GenericMyBatisDAOSupport<FarmerForest, Long>
	implements IFarmerForestDao {

}
