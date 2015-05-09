package com.bank.dao;

import java.util.List;

import com.bank.beans.FarmerBreed;
import com.common.dao.GenericDAO;

public interface IFarmerBreedDao extends GenericDAO<FarmerBreed, Long> {
	public List<FarmerBreed> getBreedsByFarmerId(Long farmerId);

}
