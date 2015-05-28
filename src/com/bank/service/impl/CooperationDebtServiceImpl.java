package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerCooperationDebt;
import com.bank.dao.ICooperationDebtDao;
import com.bank.service.ICooperationDebtService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("cooperationDebtService")
public class CooperationDebtServiceImpl  extends GenericServiceImpl<FarmerCooperationDebt, Long>  implements ICooperationDebtService {
	
	@Resource(name="cooperationDebtDao")
	private ICooperationDebtDao cooperationDebtDao;
	
	@Override
	public void save(FarmerCooperationDebt entity) throws DAOException, CreateException {
		cooperationDebtDao.save(entity);
	}

	@Override
	public void update(FarmerCooperationDebt entity) throws DAOException, UpdateException,
			DataNotFoundException {
		cooperationDebtDao.update(entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException,
			DataNotFoundException {
		
	}

	@Override
	public FarmerCooperationDebt findByPK(Long pk) throws DAOException, DataNotFoundException {
		return cooperationDebtDao.findByPK(pk);
	}

	@Override
	public List<FarmerCooperationDebt> getAllEntities() throws DAOException {
		return null;
	}

	@Override
	public List<FarmerCooperationDebt> getPageingEntities(int pageIndex, int pageSize,
			String sortField, String sortOrder, Map paramMap)
			throws DAOException {
		return cooperationDebtDao.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
	}

	@Override
	public GenericDAO<FarmerCooperationDebt, Long> getGenericDAO() {
		return this.cooperationDebtDao;
	}
	
	public long getTotal(Map<String,String> map) {
		try{
			return cooperationDebtDao.getTotal(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0L;
	}

}
