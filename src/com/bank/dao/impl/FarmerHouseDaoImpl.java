package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerHouse;
import com.bank.dao.IFarmerHouseDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerHouseDao")
public class FarmerHouseDaoImpl extends GenericMyBatisDAOSupport<FarmerHouse, Long>
	implements IFarmerHouseDao {

}
