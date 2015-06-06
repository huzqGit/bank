package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerForest;
import com.common.service.GenericService;

public interface IFarmerForestService extends
		GenericService<FarmerForest, Long> {
	public List<FarmerForest> findForestByFarmer(Long farmerId);
}
