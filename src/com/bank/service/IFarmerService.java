package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerMember;
import com.common.service.GenericService;

public interface IFarmerService extends
		GenericService<Farmer, Long> {
	public Map saveFarmer(Farmer farmer,List<FarmerMember> member);

}
