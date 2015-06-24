package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerEvaluateExample;
import com.bank.beans.FarmerInsured;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<FarmerEvaluate> findPagingByFarmerId(int pageIndex,
			int pageSize, String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start =pageIndex * pageSize;
		int end = start + pageSize;
		map.put("farmerId",farmerId);
		map.put("start",start);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		List<FarmerEvaluate> evaluates = this.getSqlSession().selectList("farmerevaluate.findPagingByFarmerId",map);
		return evaluates;
	}

	@Override
	public List<FarmerEvaluate> selectByExample(FarmerEvaluateExample example) {
		// TODO Auto-generated method stub
		List<FarmerEvaluate> evaluates = this.getSqlSession().selectList("farmerevaluate.selectByExample",example);
		return evaluates;
	}
	
}
