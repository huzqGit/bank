package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerHouse;
import com.bank.dao.IFarmerHouseDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerHouseDao")
public class FarmerHouseDaoImpl extends GenericMyBatisDAOSupport<FarmerHouse, Long>
	implements IFarmerHouseDao {

	@Override
	public List<FarmerHouse> getHousesByFarmerId(Long farmerId) {
		List<FarmerHouse> houses =this.getSqlSession().selectList("farmerhouse.findByFarmerId",farmerId);
		return houses;
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = this.getSqlSession().selectOne("farmerhouse.findTotalNumberByFarmerId",farmerId);
		return totalNumber;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerHouse> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		map.put("start",start+1);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.put("farmerId", farmerId);
		List<FarmerHouse> houses = this.getSqlSession().selectList("farmerhouse.findPagingByFarmerId",map);
		return houses;
	}

	@Override
	public List<Farmer> findByFarmers(List<Long> farmerIds) {
		List<Farmer> farmers = this.getSqlSession().selectList("farmerhouse.findByFarmers", farmerIds);
		return farmers;
	}
}
