package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.CooperationProfit;
import com.bank.beans.CooperationProfitExample;
import com.bank.dao.ICooperationProfitDao;
import com.bank.service.ICooperationProfitService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("cooperationProfitService")
public class CooperationProfitServiceImpl  extends GenericServiceImpl<CooperationProfit, Long>  implements ICooperationProfitService {
	
	@Resource(name="cooperationProfitDao")
	private ICooperationProfitDao cooperationProfittDao;
	
	@Override
	public void save(CooperationProfit entity) throws DAOException, CreateException {
		cooperationProfittDao.save(entity);
	}

	@Override
	public void update(CooperationProfit entity) throws DAOException, UpdateException,
			DataNotFoundException {
		cooperationProfittDao.update(entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException,
			DataNotFoundException {
		cooperationProfittDao.delete(pk);
	}

	@Override
	public CooperationProfit findByPK(Long pk) throws DAOException, DataNotFoundException {
		return cooperationProfittDao.findByPK(pk);
	}

	@Override
	public List<CooperationProfit> getAllEntities() throws DAOException {
		return null;
	}

	@Override
	public int countByExample(CooperationProfitExample example) {
		// TODO Auto-generated method stub
		return cooperationProfittDao.countByExample(example);
	}

	@Override
	public int deleteByExample(CooperationProfitExample example) {
		// TODO Auto-generated method stub
		return cooperationProfittDao.deleteByExample(example);
	}

	@Override
	public int insert(CooperationProfit record) {
		// TODO Auto-generated method stub
		return cooperationProfittDao.insert(record);
	}

	@Override
	public int insertSelective(CooperationProfit record) {
		// TODO Auto-generated method stub
		return  cooperationProfittDao.insertSelective(record);
	}

	@Override
	public List<CooperationProfit> selectByExample(
			CooperationProfitExample example) {
		// TODO Auto-generated method stub
		return cooperationProfittDao.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(CooperationProfit record,
			CooperationProfitExample example) {
		// TODO Auto-generated method stub
		return cooperationProfittDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CooperationProfit record,
			CooperationProfitExample example) {
		// TODO Auto-generated method stub
		return cooperationProfittDao.updateByExample(record, example);
	}

	@Override
	public GenericDAO<CooperationProfit, Long> getGenericDAO() {
		return this.cooperationProfittDao;
	}
	
	public long getTotal(Map<String,String> map) {
		try{
			return cooperationProfittDao.getTotal(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0L;
	}

}
