package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.beans.Company;
import com.bank.beans.Farmer;
import com.bank.beans.Loan;
import com.common.dao.GenericDAO;

public interface ILoanDao extends GenericDAO<Loan, Long> {
	
@SuppressWarnings("rawtypes")
public List<Loan> loadSpecialLoan(Map map);

public List<Loan> relateLoan(Farmer farmer);
public List<Loan> relateLoan(Company company);
public List<Loan> findById(int clientType, int idType,String idNum);
public Loan findByCompactNum(String compactNum);

}
