package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;



import com.bank.beans.Company;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerLoanExample;
import com.bank.dao.IFarmerLoanDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("loanDao")
public class FarmerLoanDaoImpl extends GenericMyBatisDAOSupport<FarmerLoan, Long> implements
		IFarmerLoanDao {

	@SuppressWarnings("rawtypes")
	@Override
	public List<FarmerLoan> loadSpecialLoan(Map map) {
		
		List<FarmerLoan> loans = this.getSqlSession().selectList("farmerloan.findSpecialLoan",map);
		return loans;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerLoan> relateLoan(Farmer farmer) {
		Map map = new HashMap();
		map.put("clientType", 1);
		map.put("idType", 0);
		map.put("idNum", farmer.getFarmeridnum());
		List<FarmerLoan> loans = this.getSqlSession().selectList("farmerloan.relateLoan",map);
		return loans;
	}

	@Override
	public List<FarmerLoan> relateLoan(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerLoan> findById(String clientType, String idType, String idNum) {
		Map map = new HashMap();
		map.put("clientType",clientType);
		map.put("idType", idType);
		map.put("idNum", idNum);
		List<FarmerLoan> loans = this.getSqlSession().selectList("farmerloan.findByID",map);
		return loans;
	}

	@Override
	public List<FarmerLoan> findByCompactNum(String compactNum) {
		List<FarmerLoan> loans = this.getSqlSession().selectList("farmerloan.findByCompactNum",compactNum);
		return loans;
	}

	@Override
	public FarmerLoan findByNoteNum(String noteNum) {
		FarmerLoan loan = this.getSqlSession().selectOne("farmerloan.findByNoteNum",noteNum);
		return loan;
	}

	@Override
	public List<FarmerLoan> findByFarmerId(Long farmerId) {
		List<FarmerLoan> loans = this.getSqlSession().selectList("farmerloan.findByFarmerId",farmerId);
		return loans;
	}

	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = this.getSqlSession().selectOne("farmerloan.findTotalNummberByFarmerId",farmerId);
		return totalNumber;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerLoan> findByPaging(int pageIndex, int pageSize,
			String sortField, String sortOrder, Long farmerId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		map.put("start",start);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.put("farmerId", farmerId);
		List<FarmerLoan> loans = this.getSqlSession().selectList("farmerloan.findByPaging",map);
		return loans;
	}

	@Override
	public List<FarmerLoan> findByFarmers(List<Long> farmerIds) {
		List<FarmerLoan> loans =this.getSqlSession().selectList("farmerloan.findByFarmers", farmerIds);
		return loans;
	}
	@Override
	public List<FarmerLoan> findUnBalanceByFarmer(Long farmerId) {
		List<FarmerLoan> balaces = this.getSqlSession().selectList("farmerloan.findUnbalanceByFarmer",farmerId);
		return balaces;
	}

	@Override
	public List<FarmerLoan> findBadBalanceByFarmer(Long farmerId) {
		List<FarmerLoan> balaces = this.getSqlSession().selectList("farmerloan.findBadbalanceByFarmer", farmerId);
		return balaces;
	}

	@Override
	public List<FarmerLoan> selectByExample(FarmerLoanExample example) {
		// TODO Auto-generated method stub
		List<FarmerLoan> loans = this.getSqlSession().selectList("farmerloan.selectByExample",example);
		return loans;
	}
	
}
