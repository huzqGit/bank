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
	public List<Loan> findByID(int clientType,int idType,String idNum);
	public Loan findByCompactNum(String compactNum); 
}
