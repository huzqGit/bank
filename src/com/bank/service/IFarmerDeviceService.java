package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerDeviceExample;
import com.common.service.GenericService;

public interface IFarmerDeviceService extends
		GenericService<FarmerDevice, Long> {
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerDevice> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId);
	public List<FarmerDevice> selectByExample(FarmerDeviceExample example);

}
