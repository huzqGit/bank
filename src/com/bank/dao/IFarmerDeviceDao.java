package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerDevice;
import com.common.dao.GenericDAO;

public interface IFarmerDeviceDao extends GenericDAO<FarmerDevice, Long> {
	public List<FarmerDevice> getDevicesByFarmerId(Long farmerId);

}
