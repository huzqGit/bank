package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.CooperationProfit;
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
	public List<CooperationProfit> getPageingEntities(int pageIndex, int pageSize,
			String sortField, String sortOrder, Map paramMap)
			throws DAOException {
		return cooperationProfittDao.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
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
