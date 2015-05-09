package com.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerBreed;
import com.bank.dao.IFarmerBreedDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("farmerBreedDao")
public class FarmerBreedDaoImpl extends GenericMyBatisDAOSupport<FarmerBreed, Long>
	implements IFarmerBreedDao {

	@Override
	public List<FarmerBreed> getBreedsByFarmerId(Long farmerId) {
		List<FarmerBreed> breeds = this.getSqlSession().selectList("farmerbreed.findByID", farmerId);
		return breeds;
	}

}
