package com.bank.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerInsuredExample;
import com.bank.dao.IFarmerInsuredDao;
import com.bank.service.IFarmerInsuredService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerInsuredService")
public class FarmerInsuredServiceImpl extends GenericServiceImpl<FarmerInsured, Long> 
	implements IFarmerInsuredService{
	
	@Resource
	private IFarmerInsuredDao farmerInsuredDao;

	@Override
	public GenericDAO<FarmerInsured, Long> getGenericDAO() {
		
		return this.farmerInsuredDao;
	}

	@Override
	public List<FarmerInsured> findByFarmer(Long farmerId) {
		List<FarmerInsured> insureds = farmerInsuredDao.findByFarmerId(farmerId);
		return insureds;
	}

	@Override
	public void save(Farmer farmer, List<FarmerInsured> insureds) 
			throws DAOException, CreateException, UpdateException,
			DataNotFoundException {
		if(farmer.getId() == null){
			return ;
		}else{
			for(Iterator<FarmerInsured> it = insureds.iterator();it.hasNext();){
				FarmerInsured insured = it.next();
				if(insured.getFarmerid() == null){
					insured.setFarmerid(farmer.getId());
				}
				if(insured.getId() == null){
					farmerInsuredDao.save(insured);
				}else{
					farmerInsuredDao.update(insured);
				}
			}
		}
	}

	@Override
	public List<Farmer> findByFarmers(List<Long> farmerIds) {
		List<Farmer> farmers =farmerInsuredDao.findByFarmers(farmerIds);
		return farmers;
	}

	@Override
	public List<FarmerInsured> findPagingByFarmerId(int pageIndex,
			int pageSize, String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerInsured> insureds = farmerInsuredDao.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return insureds;
	}

	@Override
	public List<FarmerInsured> selectByExample(FarmerInsuredExample example) {
		// TODO Auto-generated method stub
		List<FarmerInsured> insureds = farmerInsuredDao.selectByExample(example);
		return insureds;
	}
	

}
