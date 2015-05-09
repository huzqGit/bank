package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerCompunish;
import com.common.dao.GenericDAO;

public interface IFarmerCompunishDao extends GenericDAO<FarmerCompunish, Long> {
	
	public List<FarmerCompunish> getCompunishByFarmerId(Long farmerId);
}
