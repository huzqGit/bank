package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerDevice;
import com.common.service.GenericService;

public interface IFarmerDeviceService extends
		GenericService<FarmerDevice, Long> {
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId);

}
