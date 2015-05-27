package com.bank.dao;

import java.util.Map;

import com.bank.beans.FarmerCooperation;
import com.common.dao.GenericDAO;

public interface ICooperationDao extends GenericDAO<FarmerCooperation, Long>{
	
	public long getTotal(Map<String,String> map);
}
