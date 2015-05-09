package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Company;
import com.bank.beans.Farmer;
import com.bank.beans.Loan;
import com.bank.dao.ILoanDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("loanDao")
public class LoanDaoImpl extends GenericMyBatisDAOSupport<Loan, Long> implements
		ILoanDao {

	@SuppressWarnings("rawtypes")
	@Override
	public List<Loan> loadSpecialLoan(Map map) {
		
		List<Loan> loans = this.getSqlSession().selectList("loan.findSpecialLoan",map);
		return loans;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Loan> relateLoan(Farmer farmer) {
		Map map = new HashMap();
		map.put("clientType", 1);
		map.put("idType", 0);
		map.put("idNum", farmer.getFarmerIdnum());
		List<Loan> loans = this.getSqlSession().selectList("loan.relateLoan",map);
		return loans;
	}

	@Override
	public List<Loan> relateLoan(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Loan> findById(int clientType, int idType, String idNum) {
		Map map = new HashMap();
		map.put("clientType",clientType);
		map.put("idType", idType);
		map.put("idNum", idNum);
		List<Loan> loans = this.getSqlSession().selectList("loan.findByID",map);
		return loans;
	}

	@Override
	public Loan findByCompactNum(String compactNum) {
		Loan loan = this.getSqlSession().selectOne("loan.findByCompactNum",compactNum);
		return loan;
	}
	

	
}
