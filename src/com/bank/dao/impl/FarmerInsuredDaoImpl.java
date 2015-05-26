package com.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerInsured;
import com.bank.dao.IFarmerInsuredDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerInsuredDao")
public class FarmerInsuredDaoImpl extends GenericMyBatisDAOSupport<FarmerInsured, Long>
	implements IFarmerInsuredDao {

	@Override
	public List<FarmerInsured> findByFarmerId(Long farmerId) {
		List<FarmerInsured> insureds = this.getSqlSession().selectList("farmerinsured.findByFarmerId",farmerId);
		return insureds;
	}

	@Override
	public List<Farmer> findByFarmers(List<Long> farmerIds) {
		List<Farmer> farmers = this.getSqlSession().selectList("farmerinsured.findByFarmers",farmerIds);
		return farmers;
	}

}
