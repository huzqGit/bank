package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerDeviceExample;
import com.bank.dao.IFarmerDeviceDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerDeviceDao")
public class FarmerDeviceDaoImpl extends GenericMyBatisDAOSupport<FarmerDevice, Long>
	implements IFarmerDeviceDao {

	@Override
	public List<FarmerDevice> getDevicesByFarmerId(Long farmerId) {
		List<FarmerDevice> devices = this.getSqlSession().selectList("farmerdevice.findByID",farmerId);
		return devices;
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = this.getSqlSession().selectOne("farmerdevice.findTotalNumberByFarmerId",farmerId);
		return totalNumber;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<FarmerDevice> findPagingByFarmerId(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		map.put("start",start+1);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.put("farmerId", farmerId);
		List<FarmerDevice> devices = this.getSqlSession().selectList("farmerdevice.findPagingByFarmerId",map);
		return devices;
	}

	@Override
	public List<FarmerDevice> selectByExample(FarmerDeviceExample example) {
		// TODO Auto-generated method stub
		List<FarmerDevice> devices = this.getSqlSession().selectList("farmerdevice.selectByExample",example);
		return devices;
	}
	

}
