package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerMember;
import com.bank.dao.IFarmerMemberDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerMemberDao")
public class FarmerMemberDaoImpl extends GenericMyBatisDAOSupport<FarmerMember, Long>
	implements IFarmerMemberDao {

}
