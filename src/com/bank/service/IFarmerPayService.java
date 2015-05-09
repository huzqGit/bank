package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerPay;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public interface IFarmerPayService extends
		GenericService<FarmerPay, Long> {
	
	public void saveBalance(Farmer farmer,FarmerPay balance,List<FarmerIncome> incomes) 
			throws DAOException, DataNotFoundException,
			CreateException,UpdateException;
	
	public List<FarmerPay> loadPayByDateAndFarmer(Long farmerId,String year);
	
	public List<FarmerIncome> loadTotalIncome(Long balanceId);
	//查找用户指定年份的收支信息
	public List<FarmerPay> findByFarmerAndYear();

}
