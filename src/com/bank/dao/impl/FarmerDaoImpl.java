package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Farmer;
import com.bank.dao.IFarmerDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerDao")
public class FarmerDaoImpl extends GenericMyBatisDAOSupport<Farmer, Long>
	implements IFarmerDao {

	@Override
	public Farmer findByID(String farmerIdNum) {
		
		Farmer farmer = this.getSqlSession().selectOne("farmer.findByID",farmerIdNum);
		return farmer;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Farmer> findFarmer(Map map) {
		
		List<Farmer> farmers = this.getSqlSession().selectList("farmer.findByMultiCondition",map);
		return farmers;
	}

	@Override
	public List<Farmer> findByIDAndName(String farmerIdNum, String farmerName) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("farmerIdNum", farmerIdNum);
		map.put("farmerName", farmerName);
		List<Farmer> farmers = this.getSqlSession().selectList("farmer.findByIDAndName",map);
		return farmers;
	}

	@Override
	public List<Farmer> findByNames(List<String> farmerNames) {
		List<Farmer> farmers = this.getSqlSession().selectList("farmer.findByNames",farmerNames);
		return farmers;
	}
	
}
