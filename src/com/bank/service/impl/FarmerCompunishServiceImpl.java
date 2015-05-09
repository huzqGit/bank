package com.bank.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerEvaluate;
import com.bank.dao.IFarmerCompunishDao;
import com.bank.dao.IFarmerEvaluateDao;
import com.bank.service.IFarmerCompunishService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerCompunishService")
public class FarmerCompunishServiceImpl extends GenericServiceImpl<FarmerCompunish, Long> 
	implements IFarmerCompunishService{
	
	@Resource
	private IFarmerEvaluateDao farmerEvaluateDao;
	@Resource
	private IFarmerCompunishDao farmerCompunishDao;

	@Override
	public GenericDAO<FarmerCompunish, Long> getGenericDAO() {
		
		return this.farmerCompunishDao;
	}

	@Override
	public FarmerEvaluate getEvaluateByFarmer(Long farmerId) {
		FarmerEvaluate evaluate = farmerEvaluateDao.getEvaluateByFarmerId(farmerId);
		return evaluate;
	}

	@Override
	public List<FarmerCompunish> getCompunishByFarmer(Long farmerId) {
		List<FarmerCompunish> compunish = farmerCompunishDao.getCompunishByFarmerId(farmerId);
		return compunish;
	}

	@Override
	public void saveJiangCheng(Farmer farmer,List<FarmerCompunish> compunishs) 
		throws DAOException,CreateException, UpdateException, DataNotFoundException {
		if(farmer.getId() == null){
			return ;
		}
		for(Iterator<FarmerCompunish> it = compunishs.iterator();it.hasNext();){
			FarmerCompunish compunish = it.next();
			compunish.setFarmerId(farmer.getId());
			if(compunish.getId() == null){
				farmerCompunishDao.save(compunish);
			}else{
				farmerCompunishDao.update(compunish);
			}
		}
		
	}

}
