package com.bank.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerLoanExample;
import com.bank.dao.IFarmerDao;
import com.bank.dao.IFarmerLoanDao;
import com.bank.service.IFarmerLoanService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.impl.GenericServiceImpl;

@Service("loanService")
public class FarmerLoanServiceImpl extends GenericServiceImpl<FarmerLoan, Long>
	implements IFarmerLoanService{
	
	@Resource
	private IFarmerLoanDao loanDao;
	@Resource
	private IFarmerDao farmerDao;
	@Override
	public GenericDAO<FarmerLoan, Long> getGenericDAO() {
		return this.loanDao;
	}
	public IFarmerLoanDao getLoanDao() {
		return loanDao;
	}
	public void setLoanDao(IFarmerLoanDao loanDao) {
		this.loanDao = loanDao;
	}
	@Override
	public void loadLoan(List<FarmerLoan> loans) throws DAOException, CreateException {
		
		for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
				FarmerLoan loan = it.next();
				if(loan.getClienttype().equals("其它自然人客户")){
					Farmer farmer= farmerDao.findByID(loan.getIdnum(),loan.getRunitid());
					if(farmer == null){
						return ;
					} 
					Long farmerId=farmer.getId();
					loan.setClientid(farmerId);
					loanDao.save(loan);
				}
		}
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List<FarmerLoan> loadSpecialLoan(Map map) {
		List<FarmerLoan> loans = loanDao.loadSpecialLoan(map);
		return loans;
	}
	
	//关联农户的信贷信息
	@Override
	public int relateLoan(Farmer farmer) throws DAOException, CreateException {

		List<FarmerLoan> loans =loanDao.relateLoan(farmer);
		if(loans.size()>0){
			for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
				FarmerLoan loan = it.next();
				loanDao.save(loan);
			}
		}
		return loans.size();
	}
	/**
	 * 根据客户类型，证件类型及证件号码查找信贷信息
	 * 
	 */
	@Override
	public List<FarmerLoan> findByID(String clientType, String idType, String idNum) {
		List<FarmerLoan> loans = loanDao.findById(clientType, idType, idNum);
		return loans;
	}
	@Override
	public List<FarmerLoan> findByCompactNum(String compactNum) {
		List<FarmerLoan> loans = loanDao.findByCompactNum(compactNum);
		return loans;
	}
	
	@Override
	public FarmerLoan findByNoteNum(String noteNum) {
			FarmerLoan loan = loanDao.findByNoteNum(noteNum);

		return loan;
	}
	@Override
	public List<FarmerLoan> findByFarmerId(Long farmerId) {
		List<FarmerLoan>  loans =loanDao.findByFarmerId(farmerId);
		return loans;
	}
	
	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = loanDao.findTotalNumberByFarmerId(farmerId);
		return totalNumber;
	}
	@Override
	public List<FarmerLoan> findByPaging(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId) {
		List<FarmerLoan>  loans =loanDao.findByPaging(pageIndex,pageSize,sortField,sortOrder,farmerId);
		return loans;
	}
	@Override
	public List<FarmerLoan> findByFarmers(List<Long> farmerIds) {
		List<FarmerLoan> loans = loanDao.findByFarmers(farmerIds);
		return loans;
	}
	@Override
	public List<FarmerLoan> findUnBalanceByFarmer(Long farmerId) {
		List<FarmerLoan> unbalaces = loanDao.findUnBalanceByFarmer(farmerId);
		return unbalaces;
	}
	@Override
	public List<FarmerLoan> findBadBalanceByFarmer(Long farmerId) {
		List<FarmerLoan> badbalaces = loanDao.findBadBalanceByFarmer(farmerId);
		return badbalaces;
	}
	@Override
	public List<FarmerLoan> selectByExample(FarmerLoanExample example) {
		// TODO Auto-generated method stub
		List<FarmerLoan> loans = loanDao.selectByExample(example);
		return loans;
	}
	
}
