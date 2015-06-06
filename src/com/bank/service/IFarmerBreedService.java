package com.bank.service;

import java.util.List;

import com.bank.beans.FarmerBreed;
import com.common.service.GenericService;

public interface IFarmerBreedService extends
		GenericService<FarmerBreed, Long> {
	public List<FarmerBreed> findBreedByFarmer(Long farmerId);

}
