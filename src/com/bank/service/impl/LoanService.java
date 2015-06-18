package com.bank.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.Loan;
import com.bank.dao.IFarmerDao;
import com.bank.dao.ILoanDao;
import com.bank.service.ILoanService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.impl.GenericServiceImpl;

@Service("loanService")
public class LoanService extends GenericServiceImpl<Loan, Long>
	implements ILoanService{
	
	@Resource
	private ILoanDao loanDao;
	@Resource
	private IFarmerDao farmerDao;
	@Override
	public GenericDAO<Loan, Long> getGenericDAO() {
		return this.loanDao;
	}
	public ILoanDao getLoanDao() {
		return loanDao;
	}
	public void setLoanDao(ILoanDao loanDao) {
		this.loanDao = loanDao;
	}
	@Override
	public void loadLoan(List<Loan> loans) throws DAOException, CreateException {
		
		for(Iterator<Loan> it = loans.iterator();it.hasNext();){
				Loan loan = it.next();
				if(loan.getClientType().equals("其它自然人客户")){
					Farmer farmer= farmerDao.findByID(loan.getIdNum(),loan.getRunitId());
					if(farmer == null){
						return ;
					} 
					Long farmerId=farmer.getId();
					loan.setClientId(farmerId);
					loanDao.save(loan);
				}
		}
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List<Loan> loadSpecialLoan(Map map) {
		List<Loan> loans = loanDao.loadSpecialLoan(map);
		return loans;
	}
	
	//关联农户的信贷信息
	@Override
	public int relateLoan(Farmer farmer) throws DAOException, CreateException {

		List<Loan> loans =loanDao.relateLoan(farmer);
		if(loans.size()>0){
			for(Iterator<Loan> it = loans.iterator();it.hasNext();){
				Loan loan = it.next();
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
	public List<Loan> findByID(String clientType, String idType, String idNum) {
		List<Loan> loans = loanDao.findById(clientType, idType, idNum);
		return loans;
	}
	@Override
	public List<Loan> findByCompactNum(String compactNum) {
		List<Loan> loans = loanDao.findByCompactNum(compactNum);
		return loans;
	}
	
	@Override
	public Loan findByNoteNum(String noteNum) {
			Loan loan = loanDao.findByNoteNum(noteNum);

		return loan;
	}
	@Override
	public List<Loan> findByFarmerId(Long farmerId) {
		List<Loan>  loans =loanDao.findByFarmerId(farmerId);
		return loans;
	}
	
	@Override
	public int findTotalNumberByFarmerId(Long farmerId) {
		// TODO Auto-generated method stub
		int totalNumber = loanDao.findTotalNumberByFarmerId(farmerId);
		return totalNumber;
	}
	@Override
	public List<Loan> findByPaging(int pageIndex,int pageSize,String sortField,
			String sortOrder,Long farmerId) {
		List<Loan>  loans =loanDao.findByPaging(pageIndex,pageSize,sortField,sortOrder,farmerId);
		return loans;
	}
	@Override
	public List<Loan> findByFarmers(List<Long> farmerIds) {
		List<Loan> loans = loanDao.findByFarmers(farmerIds);
		return loans;
	}
	@Override
	public List<Loan> findUnBalanceByFarmer(Long farmerId) {
		List<Loan> unbalaces = loanDao.findUnBalanceByFarmer(farmerId);
		return unbalaces;
	}
	@Override
	public List<Loan> findBadBalanceByFarmer(Long farmerId) {
		List<Loan> badbalaces = loanDao.findBadBalanceByFarmer(farmerId);
		return badbalaces;
	}
	
}
