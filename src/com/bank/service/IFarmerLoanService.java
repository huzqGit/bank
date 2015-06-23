package com.bank.service;

import java.util.List;
import java.util.Map;



import com.bank.beans.Farmer;
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerLoanExample;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.GenericService;

public interface IFarmerLoanService extends GenericService<FarmerLoan, Long> {
	
	public void loadLoan(List<FarmerLoan> loans) throws DAOException, CreateException;
	
	@SuppressWarnings("rawtypes")
	public List<FarmerLoan> loadSpecialLoan(Map map);
	public int relateLoan(Farmer farmer) throws DAOException, CreateException;
	public List<FarmerLoan> findByID(String clientType,String idType,String idNum);
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
