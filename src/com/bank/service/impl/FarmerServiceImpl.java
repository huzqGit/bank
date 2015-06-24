package com.bank.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;





import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.beans.Apply;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerPay;
import com.bank.beans.FarmerLoan;
import com.bank.dao.IFarmerBreedDao;
import com.bank.dao.IFarmerCompunishDao;
import com.bank.dao.IFarmerDao;
import com.bank.dao.IFarmerDeviceDao;
import com.bank.dao.IFarmerEvaluateDao;
import com.bank.dao.IFarmerForestDao;
import com.bank.dao.IFarmerHouseDao;
import com.bank.dao.IFarmerIncomeDao;
import com.bank.dao.IFarmerInsuredDao;
import com.bank.dao.IFarmerMemberDao;
import com.bank.dao.IFarmerPayDao;
import com.bank.dao.IFarmerLoanDao;
import com.bank.service.IFarmerService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerService")
public class FarmerServiceImpl extends GenericServiceImpl<Farmer, Long> 
	implements IFarmerService{
	
	@Resource
	private IFarmerDao farmerDao;
	@Resource
	private IFarmerMemberDao farmerMemberDao;
	@Resource
	private IFarmerHouseDao farmerHouseDao;
	@Resource
	private IFarmerForestDao farmerForestDao;
	@Resource
	private IFarmerBreedDao farmerBreedDao;
	@Resource
	private IFarmerDeviceDao farmerDeviceDao;
	@Resource
	private IFarmerPayDao farmerPayDao;
	@Resource
	private IFarmerIncomeDao farmerIncomeDao;
	@Resource
	private IFarmerEvaluateDao farmerEvaluateDao;
	@Resource
	private IFarmerCompunishDao farmerCompunishDao;
	@Resource
	private IFarmerLoanDao loanDao;
	@Resource
	private IFarmerInsuredDao farmerInsuredDao;
	@Override
	public GenericDAO<Farmer, Long> getGenericDAO() {
		
		return this.farmerDao;
	}
	
	@Override
	public void updateBySelective(Farmer farmer) {
		// TODO Auto-generated method stub
		farmerDao.updateBySelective(farmer);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int findTotalNumber(Map paramMap) {
		// TODO Auto-generated method stub
		int totalNumber = farmerDao.findTotalNumber(paramMap);
		return totalNumber;
	}
	
	@Override
	public void saveAapply(Apply apply) {
		farmerDao.saveApply(apply);
	}


	@Override
	public List<Apply> findApplyByUser(String userId) {
		List<Apply> applys = farmerDao.findApplyByUser(userId);
		return applys;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map loadFarmer(Long farmerId) throws DAOException, DataNotFoundException {
		Map map = new HashMap();
		Farmer farmer =farmerDao.findByPK(farmerId);
		List<FarmerMember> members = farmerMemberDao.getMembersByFarmerId(farmerId);
		List<FarmerLoan> loans = loanDao.findByFarmerId(farmerId);
		List<FarmerHouse> houses = farmerHouseDao.getHousesByFarmerId(farmerId);
		List<FarmerForest> forests = farmerForestDao.getForestsByFarmerId(farmerId);
		List<FarmerBreed> breeds = farmerBreedDao.getBreedsByFarmerId(farmerId);
		List<FarmerDevice> devices = farmerDeviceDao.getDevicesByFarmerId(farmerId);
		List<FarmerPay> balances = farmerPayDao.findByFarmer(farmerId);
		FarmerEvaluate evaluate = farmerEvaluateDao.getEvaluateByFarmerId(farmerId);
		List<FarmerCompunish> compunishs = farmerCompunishDao.getCompunishByFarmerId(farmerId);
		List<FarmerInsured> insureds = farmerInsuredDao.findByFarmerId(farmerId);
		map.put("farmer", farmer);
		map.put("members", members);
		map.put("loans", loans);
		map.put("houses", houses);
		map.put("breeds", breeds);
		map.put("devices", devices);
		map.put("forests", forests);
		map.put("balances", balances);
		map.put("evaluate", evaluate);
		map.put("compunishs", compunishs);
		map.put("insureds", insureds);
		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map loadTotalFarmer(Long farmerId) throws Exception {

		Map map = new HashMap();
		Farmer farmer =farmerDao.findByPK(farmerId);
		List<FarmerMember> members = farmerMemberDao.getMembersByFarmerId(farmerId);
		List<FarmerLoan> loans = loanDao.findByFarmerId(farmerId);
		List<FarmerHouse> houses = farmerHouseDao.getHousesByFarmerId(farmerId);
		List<FarmerForest> forests = farmerForestDao.getForestsByFarmerId(farmerId);
		List<FarmerBreed> breeds = farmerBreedDao.getBreedsByFarmerId(farmerId);
		List<FarmerDevice> devices = farmerDeviceDao.getDevicesByFarmerId(farmerId);
		FarmerPay balance = farmerPayDao.findLatestByFarmer(farmerId);
		List<FarmerIncome> incomes = new ArrayList<FarmerIncome>();
		if(balance != null){
			 incomes =farmerIncomeDao.findAll(balance.getId());
		}
		FarmerEvaluate evaluate = farmerEvaluateDao.getEvaluateByFarmerId(farmerId);
		List<FarmerCompunish> compunishs = farmerCompunishDao.getCompunishByFarmerId(farmerId);
		List<FarmerInsured> insureds = farmerInsuredDao.findByFarmerId(farmerId);
		map.put("farmer", farmer);
		map.put("members", members);
		map.put("loans", loans);
		map.put("houses", houses);
		map.put("breeds", breeds);
		map.put("devices", devices);
		map.put("forests", forests);
		map.put("balance", balance);
		map.put("incomes", incomes);
		map.put("evaluate", evaluate);
		map.put("compunishs", compunishs);
		map.put("insureds", insureds);
		return map;
	
	}


	@Override
	public List<Farmer> findByFarmerIds(List<Long> farmerIds) {
		List<Farmer> farmers = farmerDao.findByFarmerIds(farmerIds);
		return farmers;
	}


	@Override
	public List<Farmer> findPagingByPK(int pageIndex, int pageSize,
			String sortField, String sortOrder, List<Long> farmerIds) {
		// TODO Auto-generated method stub
		List<Farmer> farmers = farmerDao.findPagingByPK(pageIndex, pageSize, sortField, sortOrder, farmerIds);
		return farmers;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public List<Farmer> loadFarmers(Map condition) throws DAOException,
			DataNotFoundException {
			List<Farmer> farmers = farmerDao.findFarmer(condition);
		return farmers;
	}

	@Override
	public Farmer findById(String idNum,String organId) {
		Farmer farmer = farmerDao.findByID(idNum,organId);
		return farmer;
	}


	@Override
	public List<Farmer> findByIDAndName(String farmerIdNum, String farmerName) {
		List<Farmer> farmers = farmerDao.findByIDAndName(farmerIdNum, farmerName);
		return farmers;
	}


	@Override
	public List<Farmer> findPagingByIDAndName(String pageIndex,
			String pageSize, String sortField, String sortOrder,
			String farmerIdNum, String farmerName, String organId) {
		// TODO Auto-generated method stub
		List<Farmer> farmers = farmerDao.findPagingByIDAndName(pageIndex, pageSize, sortField, sortOrder,
				farmerIdNum, farmerName, organId);
		return farmers;
	}


	@Override
	public List<Farmer> findByNames(List<String> farmerNames) {
		List<Farmer> farmers = farmerDao.findByNames(farmerNames);
		return farmers;
	}

	@Override
	public List<FarmerMember> findMemberByFarmer(Long farmerId) {
		List<FarmerMember> members = farmerMemberDao.getMembersByFarmerId(farmerId);
		return members;
	}
	

	@Override
	public List<FarmerHouse> findHouseByFarmer(Long farmerId) {
		List<FarmerHouse> houses = farmerHouseDao.getHousesByFarmerId(farmerId);
		return houses;
	}


	@Override
	public List<FarmerForest> findForestByFarmer(Long farmerId) {
		List<FarmerForest> forests = farmerForestDao.getForestsByFarmerId(farmerId);
		return forests;
	}


	@Override
	public List<FarmerBreed> findBreedByFarmer(Long farmerId) {
		List<FarmerBreed> breeds = farmerBreedDao.getBreedsByFarmerId(farmerId);
		return breeds;
	}


	@Override
	public List<FarmerDevice> findDeviceByFarmer(Long farmerId) {
		List<FarmerDevice> devices = farmerDeviceDao.getDevicesByFarmerId(farmerId);
		return devices;
	}


	@Override
	public FarmerEvaluate findEvaluateByFarmer(Long farmerId) {
		FarmerEvaluate evaluate = farmerEvaluateDao.getEvaluateByFarmerId(farmerId);
		return evaluate;
	}


	@Override
	public List<FarmerCompunish> findCompunishByFarmer(Long farmerId) {
		List<FarmerCompunish> compunishs = farmerCompunishDao.getCompunishByFarmerId(farmerId);
		return compunishs;
	}


	@Override
	public List<FarmerLoan> findLoanByFarmer(Long farmerId) {
		List<FarmerLoan> loans = loanDao.findByFarmerId(farmerId);
		return loans;
	}

	@Override
	public List<FarmerPay> findBalanceByFarmer(Long farmerId) {
		// TODO Auto-generated method stub
		List<FarmerPay> balances = farmerPayDao.findByFarmer(farmerId);
		return balances;
	}


	@Override
	public FarmerPay findLatestBalanceByFarmer(Long farmerId) {
		FarmerPay balance = farmerPayDao.findLatestByFarmer(farmerId);
		return balance;
	}


	@Override
	public List<FarmerInsured> findInsuredByFarmer(Long farmerId) {
		List<FarmerInsured> insureds = farmerInsuredDao.findByFarmerId(farmerId);
		return insureds;
	}


	@Override
	public void deleteMembers(List<Long> memberIds) {
		// TODO Auto-generated method stub
		farmerMemberDao.deleteMembers(memberIds);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Farmer findSignalByWhereClause(@Param("example")Map param) {
		// TODO Auto-generated method stub
		Farmer farmer = farmerDao.findSignalByWhereClause(param);
		return farmer;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Farmer> findMultiByWhereClause(@Param("example")Map param) {
		// TODO Auto-generated method stub
		List<Farmer> farmers = farmerDao.findMultiByWhereClause(param);
		return farmers;
	}

	@Override
	public List<Farmer> selectByExample(FarmerExample example) {
		// TODO Auto-generated method stub
		List<Farmer> farmers = farmerDao.selectByExample(example);
		return farmers;
	}	
	
}
