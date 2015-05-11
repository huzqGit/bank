package com.bank.service;

import java.util.List;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerEvaluate;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerCompunishService extends
		GenericService<FarmerCompunish, Long> {
	public FarmerEvaluate getEvaluateByFarmer(Long farmerId);
	public List<FarmerCompunish> getCompunishByFarmer(Long farmerId);
	public void saveJiangCheng(Farmer farmer,List<FarmerCompunish> compunishs)throws DAOException, 
			CreateException, UpdateException, DataNotFoundException;

}
