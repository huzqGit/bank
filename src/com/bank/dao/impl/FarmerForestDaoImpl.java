package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerForestExample;
import com.bank.dao.IFarmerForestDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerForestDao")
public class FarmerForestDaoImpl extends GenericMyBatisDAOSupport<FarmerForest, Long>
	implements IFarmerForestDao {

	
	@Override
	public int countByExample(FarmerForestExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne("farmerforest.countByExample", example);
		return num;
	}

	@Override
	public List<FarmerForest> getForestsByFarmerId(Long farmerId) {
		List<FarmerForest> forests =this.getSqlSession().selectList("farmerforest.findByFarmerId", farmerId);
		return forests;
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = this.getSqlSession().selectOne("farmerforest.findTotalNumberByFarmerId",farmerId);
		return totalNumber;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<FarmerForest> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		map.put("start",start+1);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.put("farmerId", farmerId);
		List<FarmerForest> forests = this.getSqlSession().selectList("farmerforest.findPagingByFarmerId",map);
		return forests;
	}

	@Override
	public List<FarmerForest> selectByExample(FarmerForestExample example) {
		// TODO Auto-generated method stub
		List<FarmerForest> forests = this.getSqlSession().selectList("farmerforest.selectByExample",example);
		return forests;
	}
	
	

}
