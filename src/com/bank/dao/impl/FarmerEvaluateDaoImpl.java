package com.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerEvaluate;
import com.bank.dao.IFarmerEvaluateDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerEvaluateDao")
public class FarmerEvaluateDaoImpl extends GenericMyBatisDAOSupport<FarmerEvaluate, Long>
	implements IFarmerEvaluateDao {

	@Override
	public FarmerEvaluate getEvaluateByFarmerId(Long farmerId) {
		FarmerEvaluate evaluate =this.getSqlSession().selectOne("farmerevaluate.findByFarmerId",farmerId);
		return evaluate;
	}

	@Override
	public List<Farmer> findByFarmers(List<Long> farmerIds) {
		List<Farmer> farmers = this.getSqlSession().selectList("farmerevaluate.findByFarmers",farmerIds);
		return farmers;
	}

	@Override
	public FarmerEvaluate findByFarmer(Long farmerId) {
		FarmerEvaluate evaluate = this.getSqlSession().selectOne("farmerevaluate.findByFarmerId",farmerId);
		return evaluate;
	}
	
}
