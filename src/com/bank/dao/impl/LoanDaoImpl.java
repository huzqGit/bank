package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Company;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerPay;
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
	public List<Loan> findById(String clientType, String idType, String idNum) {
		Map map = new HashMap();
		map.put("clientType",clientType);
		map.put("idType", idType);
		map.put("idNum", idNum);
		List<Loan> loans = this.getSqlSession().selectList("loan.findByID",map);
		return loans;
	}

	@Override
	public List<Loan> findByCompactNum(String compactNum) {
		List<Loan> loans = this.getSqlSession().selectList("loan.findByCompactNum",compactNum);
		return loans;
	}

	@Override
	public Loan findByNoteNum(String noteNum) {
		Loan loan = this.getSqlSession().selectOne("loan.findByNoteNum",noteNum);
		return loan;
	}

	@Override
	public List<Loan> findByFarmerId(long farmerId) {
		List<Loan> loans = this.getSqlSession().selectList("loan.findByFarmerId",farmerId);
		return loans;
	}

	@Override
	public List<Loan> findByFarmers(List<Long> farmerIds) {
		List<Loan> loans =this.getSqlSession().selectList("loan.findByFarmers", farmerIds);
		return loans;
	}
	@Override
	public List<Loan> findUnBalanceByFarmer(Long farmerId) {
		List<Loan> balaces = this.getSqlSession().selectList("loan.findUnbalanceByFarmer",farmerId);
		return balaces;
	}

	@Override
	public List<Loan> findBadBalanceByFarmer(Long farmerId) {
		List<Loan> balaces = this.getSqlSession().selectList("loan.findBadbalanceByFarmer", farmerId);
		return balaces;
	}
}
