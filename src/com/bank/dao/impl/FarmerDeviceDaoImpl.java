package com.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerDevice;
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
	

}
