package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.CooperationDebt;
import com.bank.beans.CooperationDebtExample;
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
public class CooperationDebtServiceImpl  extends GenericServiceImpl<CooperationDebt, Long>  implements ICooperationDebtService {
	
	@Resource(name="cooperationDebtDao")
	private ICooperationDebtDao cooperationDebtDao;
	
	@Override
	public void save(CooperationDebt entity) throws DAOException, CreateException {
		cooperationDebtDao.save(entity);
	}

	@Override
	public void update(CooperationDebt entity) throws DAOException, UpdateException,
			DataNotFoundException {
		cooperationDebtDao.update(entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException,
			DataNotFoundException {
		cooperationDebtDao.delete(pk);
	}

	@Override
	public CooperationDebt findByPK(Long pk) throws DAOException, DataNotFoundException {
		return cooperationDebtDao.findByPK(pk);
	}

	@Override
	public List<CooperationDebt> getAllEntities() throws DAOException {
		return null;
	}

	@Override
	public Long getUnitId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByExample(CooperationDebtExample example) {
		// TODO Auto-generated method stub
		return cooperationDebtDao.countByExample(example);
	}

	@Override
	public int deleteByExample(CooperationDebtExample example) {
		// TODO Auto-generated method stub
		return cooperationDebtDao.deleteByExample(example);
	}

	@Override
	public int insert(CooperationDebt record) {
		// TODO Auto-generated method stub
		return cooperationDebtDao.insert(record);
	}

	@Override
	public int insertSelective(CooperationDebt record) {
		// TODO Auto-generated method stub
		return cooperationDebtDao.insertSelective(record);
	}

	@Override
	public List<CooperationDebt> selectByExample(CooperationDebtExample example) {
		// TODO Auto-generated method stub
		return cooperationDebtDao.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(CooperationDebt record,
			CooperationDebtExample example) {
		// TODO Auto-generated method stub
		return cooperationDebtDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CooperationDebt record,
			CooperationDebtExample example) {
		// TODO Auto-generated method stub
		return cooperationDebtDao.updateByExample(record, example);
	}

	@Override
	public GenericDAO<CooperationDebt, Long> getGenericDAO() {
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
