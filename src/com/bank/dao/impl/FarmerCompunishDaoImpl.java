package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerCompunishExample;
import com.bank.dao.IFarmerCompunishDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerCompunishDao")
public class FarmerCompunishDaoImpl extends GenericMyBatisDAOSupport<FarmerCompunish, Long>
	implements IFarmerCompunishDao {

	@Override
	public int countByExample(FarmerCompunishExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne("farmercompunish.countByExample", example);
		return num;
	}

	@Override
	public List<FarmerCompunish> getCompunishByFarmerId(Long farmerId) {
		
		List<FarmerCompunish> compunishs = this.getSqlSession().selectList("farmercompunish.findByFarmerId",farmerId);
		return compunishs;
	}

	@Override
	public List<FarmerCompunish> findByFarmers(List<Long> farmerIds) {
		List<FarmerCompunish> compunishs = this.getSqlSession().selectList("farmercompunish.findByFarmers", farmerIds);
		return compunishs;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerCompunish> findPagingByFarmerId(int pageIndex,int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start =pageIndex * pageSize;
		int end = start + pageSize;
		map.put("farmerId",farmerId);
		map.put("start",start);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		List<FarmerCompunish> compunishs = this.getSqlSession().selectList("farmercompunish.findPagingByFarmerId",map);
		return compunishs;
	}

	@Override
	public List<FarmerCompunish> selectByExample(FarmerCompunishExample example) {
		// TODO Auto-generated method stub
		List<FarmerCompunish> compunishs = this.getSqlSession().selectList("farmercompunish.selectByExample",example);
		return compunishs;
	}
	

}
