package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerDeviceExample;
import com.common.dao.GenericDAO;

public interface IFarmerDeviceDao extends GenericDAO<FarmerDevice, Long> {
	public List<FarmerDevice> getDevicesByFarmerId(Long farmerId);
	public int findTotalNumberByFarmerId(Long farmerId);
	public List<FarmerDevice> findPagingByFarmerId(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId);
	public List<FarmerDevice> selectByExample(FarmerDeviceExample example);
}
