package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerEvaluate;
import com.bank.dao.IFarmerEvaluateDao;
import com.bank.service.IFarmerEvaluateService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerEvaluateService")
public class FarmerEvaluateServiceImpl extends GenericServiceImpl<FarmerEvaluate, Long> 
	implements IFarmerEvaluateService{
	
	@Resource
	private IFarmerEvaluateDao farmerEvaluateDao;

	@Override
	public GenericDAO<FarmerEvaluate, Long> getGenericDAO() {
		
		return this.farmerEvaluateDao;
	}

	@Override
	public void saveEvaluate(Farmer farmer, FarmerEvaluate evaluate)
			throws DAOException, CreateException, UpdateException,
			DataNotFoundException {
		if(farmer.getId() == null){
			return ;
		}
		evaluate.setFarmerId(farmer.getId());
		if(evaluate.getId() == null){
			farmerEvaluateDao.save(evaluate);
		}else{
			farmerEvaluateDao.update(evaluate);
		}
	}

	@Override
	public FarmerEvaluate getEvaluateByFarmer(Long farmerId) {
		FarmerEvaluate evaluate = farmerEvaluateDao.getEvaluateByFarmerId(farmerId);
		return evaluate;
	}

	@Override
	public List<Farmer> findByFarmers(List<Long> farmerIds) {
		List<Farmer> farmers = farmerEvaluateDao.findByFarmers(farmerIds);
		return farmers;
	}

	@Override
	public FarmerEvaluate findByID(Long farmerId) {
		FarmerEvaluate evaluate = farmerEvaluateDao.findByFarmer(farmerId);
		return evaluate;
	}

	@Override
	public List<FarmerEvaluate> findPagingByFarmerId(int pageIndex,
			int pageSize, String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerEvaluate> evaluates = farmerEvaluateDao.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
		return evaluates;
	}
	

}
