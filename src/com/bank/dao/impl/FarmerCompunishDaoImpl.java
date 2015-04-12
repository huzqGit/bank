package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerCompunish;
import com.bank.dao.IFarmerCompunishDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerCompunishDao")
public class FarmerCompunishDaoImpl extends GenericMyBatisDAOSupport<FarmerCompunish, Long>
	implements IFarmerCompunishDao {

}
