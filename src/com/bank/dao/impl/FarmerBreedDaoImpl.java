package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerBreedExample;
import com.bank.dao.IFarmerBreedDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerBreedDao")
public class FarmerBreedDaoImpl extends GenericMyBatisDAOSupport<FarmerBreed, Long>
	implements IFarmerBreedDao {

	@Override
	public List<FarmerBreed> getBreedsByFarmerId(Long farmerId) {
		List<FarmerBreed> breeds = this.getSqlSession().selectList("farmerbreed.findByID", farmerId);
		return breeds;
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = this.getSqlSession().selectOne("farmerbreed.findTotalNumberByFarmerId",farmerId);
		return totalNumber;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<FarmerBreed> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		map.put("start",start+1);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.put("farmerId", farmerId);
		List<FarmerBreed> breeds = this.getSqlSession().selectList("farmerbreed.findPagingByFarmerId",map);
		return breeds;
	}

	@Override
	public List<FarmerBreed> selectByExample(FarmerBreedExample example) {
		// TODO Auto-generated method stub
		List<FarmerBreed> breeds = this.getSqlSession().selectList("farmerbreed.selectByExample",example);
		return breeds;
	}

}
