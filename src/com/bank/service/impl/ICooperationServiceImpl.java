package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.FarmerCooperation;
import com.bank.dao.ICooperationDao;
import com.bank.service.ICooperationService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("cooperationService")
public class ICooperationServiceImpl  extends GenericServiceImpl<FarmerCooperation, Long>  implements ICooperationService {
	
	@Resource(name="cooperationDao")
	private ICooperationDao cooperationDao;
	
	@Override
	public void save(FarmerCooperation entity) throws DAOException, CreateException {
		cooperationDao.save(entity);
	}

	@Override
	public void update(FarmerCooperation entity) throws DAOException, UpdateException,
			DataNotFoundException {
		cooperationDao.update(entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException,
			DataNotFoundException {
		
	}

	@Override
	public FarmerCooperation findByPK(Long pk) throws DAOException, DataNotFoundException {
		return cooperationDao.findByPK(pk);
	}

	@Override
	public List<FarmerCooperation> getAllEntities() throws DAOException {
		return null;
	}

	@Override
	public List<FarmerCooperation> getPageingEntities(int pageIndex, int pageSize,
			String sortField, String sortOrder, Map paramMap)
			throws DAOException {
		return cooperationDao.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
	}

	@Override
	public GenericDAO<FarmerCooperation, Long> getGenericDAO() {
		return this.cooperationDao;
	}
	
	public long getTotal(Map<String,String> map) {
		try{
			return cooperationDao.getTotal(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0L;
	}

}
