package com.bank.dao;

import java.util.List;
import java.util.Map;



import com.bank.beans.Company;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerLoanExample;
import com.common.dao.GenericDAO;

public interface IFarmerLoanDao extends GenericDAO<FarmerLoan, Long> {
	
@SuppressWarnings("rawtypes")
public List<FarmerLoan> loadSpecialLoan(Map map);

public List<FarmerLoan> relateLoan(Farmer farmer);
public List<FarmerLoan> relateLoan(Company company);
public List<FarmerLoan> findById(String clientType, String idType,String idNum);
public List<FarmerLoan> findByCompactNum(String compactNum);
public FarmerLoan findByNoteNum(String noteNum);
public List<FarmerLoan> findByFarmerId(Long farmerId);
public int findTotalNumberByFarmerId(Long farmerId);
public List<FarmerLoan> findByPaging(int pageIndex,int pageSize,String sortField,
		String sortOrder,Long farmerId);
public List<FarmerLoan> findByFarmers(List<Long> farmerIds);
public List<FarmerLoan> findUnBalanceByFarmer(Long farmerId);
public List<FarmerLoan> findBadBalanceByFarmer(Long farmerId);
public List<FarmerLoan> selectByExample(FarmerLoanExample example);
}
