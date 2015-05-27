package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.Farmer;
import com.bank.beans.Loan;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.GenericService;

public interface ILoanService extends GenericService<Loan, Long> {
	
	public void loadLoan(List<Loan> loans) throws DAOException, CreateException;
	
	@SuppressWarnings("rawtypes")
	public List<Loan> loadSpecialLoan(Map map);
	public int relateLoan(Farmer farmer) throws DAOException, CreateException;
	public List<Loan> findByID(String clientType,String idType,String idNum);
	public List<Loan> findByCompactNum(String compactNum); 
	public Loan findByNoteNum(String noteNum);
	public List<Loan> findByFarmerId(long farmerId);
	public List<Loan> findByFarmers(List<Long> farmerIds);
	public List<Loan> findUnBalanceByFarmer(Long farmerId);
	public List<Loan> findBadBalanceByFarmer(Long farmerId);
}
