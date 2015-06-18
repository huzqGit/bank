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
public List<Loan> findById(String clientType, String idType,String idNum);
public List<Loan> findByCompactNum(String compactNum);
public Loan findByNoteNum(String noteNum);
public List<Loan> findByFarmerId(Long farmerId);
public int findTotalNumberByFarmerId(Long farmerId);
public List<Loan> findByPaging(int pageIndex,int pageSize,String sortField,
		String sortOrder,Long farmerId);
public List<Loan> findByFarmers(List<Long> farmerIds);
public List<Loan> findUnBalanceByFarmer(Long farmerId);
public List<Loan> findBadBalanceByFarmer(Long farmerId);

}
