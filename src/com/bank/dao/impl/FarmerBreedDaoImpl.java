package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerBreed;
import com.bank.dao.IFarmerBreedDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerBreedDao")
public class FarmerBreedDaoImpl extends GenericMyBatisDAOSupport<FarmerBreed, Long>
	implements IFarmerBreedDao {

}
