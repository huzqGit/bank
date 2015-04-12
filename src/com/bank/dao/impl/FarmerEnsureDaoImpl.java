package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerEnsure;
import com.bank.dao.IFarmerEnsureDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerEnsureDao")
public class FarmerEnsureDaoImpl extends GenericMyBatisDAOSupport<FarmerEnsure, Long>
	implements IFarmerEnsureDao {

}
