package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerPrivateLending;
import com.bank.dao.IFarmerPrivateLendingDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerPrivateLendingDao")
public class FarmerPrivateLendingImpl extends GenericMyBatisDAOSupport<FarmerPrivateLending, Long> 
	implements IFarmerPrivateLendingDao {

	@Override
	public int findTotalNumber(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = this.getSqlSession().selectOne("farmerprivatelending.findTotalNumber",farmerId);
		return totalNumber;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<FarmerPrivateLending> findByPaging(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		map.put("start",start);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.put("farmerId", farmerId);
		List<FarmerPrivateLending> lendings = this.getSqlSession().selectList("farmerprivatelending.findByPaging",map);
		return lendings;
	}

}
