package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.Farmer;
import com.bank.dao.IFarmerDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerDao")
public class FarmerDaoImpl extends GenericMyBatisDAOSupport<Farmer, Long>
	implements IFarmerDao {

	@Override
	public Farmer findByID(String farmerIdNum) {
		Farmer farmer=this.getSqlSession().selectOne(farmerIdNum);
		return farmer;
	}

}
