package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerInsuredExample;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerInsured> findPagingByFarmerId(int pageIndex,
			int pageSize, String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start =pageIndex * pageSize;
		int end = start + pageSize;
		map.put("farmerId",farmerId);
		map.put("start",start);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		List<FarmerInsured> insureds = this.getSqlSession().selectList("farmerinsured.findPagingByFarmerId",map);
		return insureds;
	}

	@Override
	public List<FarmerInsured> selectByExample(FarmerInsuredExample example) {
		// TODO Auto-generated method stub
		List<FarmerInsured> insureds = this.getSqlSession().selectList("farmerinsured.selectByExample",example);
		return insureds;
	}

}
