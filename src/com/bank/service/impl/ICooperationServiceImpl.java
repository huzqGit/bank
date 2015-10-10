package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;
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
public class ICooperationServiceImpl  extends GenericServiceImpl<Cooperation, Long>  implements ICooperationService {
	
	@Resource(name="cooperationDao")
	private ICooperationDao cooperationDao;
	
	@Override
	public void save(Cooperation entity) throws DAOException, CreateException {
		cooperationDao.save(entity);
	}

	@Override
	public void update(Cooperation entity) throws DAOException, UpdateException,
			DataNotFoundException {
		cooperationDao.update(entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException,
			DataNotFoundException {
		cooperationDao.delete(pk);
	}

	@Override
	public Cooperation findByPK(Long pk) throws DAOException, DataNotFoundException {
		return cooperationDao.findByPK(pk);
	}

	@Override
	public List<Cooperation> getAllEntities() throws DAOException {
		return null;
	}

	
	public List<Map<String,Object>> getCooperationTree(Map<String,Object> paramMap){
		return cooperationDao.getCooperationTree(paramMap);
	}
	

	@Override
	public int countByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		return cooperationDao.countByExample(example);
	}

	@Override
	public int deleteByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		return cooperationDao.deleteByExample(example) ;
	}

	@Override
	public int insert(Cooperation record) {
		// TODO Auto-generated method stub
		return cooperationDao.insert(record);
	}

	@Override
	public int insertSelective(Cooperation record) {
		// TODO Auto-generated method stub
		return cooperationDao.insertSelective(record);
	}

	@Override
	public List<Cooperation> selectByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		return cooperationDao.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Cooperation record,
			CooperationExample example) {
		// TODO Auto-generated method stub
		return cooperationDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Cooperation record, CooperationExample example) {
		// TODO Auto-generated method stub
		return cooperationDao.updateByExampleSelective(record, example);
	}

	@Override
	public GenericDAO<Cooperation, Long> getGenericDAO() {
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
