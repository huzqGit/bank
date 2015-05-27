package com.bank.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerCooperation;
import com.bank.dao.ICooperationDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@Repository("cooperationDao")
public class CooperationImpl extends GenericMyBatisDAOSupport<FarmerCooperation,Long> implements ICooperationDao {

	@Override
	public void save(FarmerCooperation entity) throws DAOException,
			CreateException {
		this.getSqlSession().insert("cooperation.save", entity);
	}

	@Override
	public void update(FarmerCooperation entity) throws DAOException,
			UpdateException {
		this.getSqlSession().update("cooperation.update", entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException{

	}

	@Override
	public FarmerCooperation findByPK(Long pk) throws DAOException,
			DataNotFoundException {
		return getSqlSession().selectOne("cooperation.findByPK", pk);
	}

	@Override
	public List<FarmerCooperation> getAllEntities() throws DAOException {
		return null;
	}

	@Override
	public List<FarmerCooperation> getPageingEntities(int pageIndex,
			int pageSize, String sortField, String sortOrder,Map map)
			throws DAOException {
		int start = pageIndex * pageSize, end = start + pageSize;
		if (!"desc".equals(sortOrder))
			sortOrder = "asc";
		map.put("start", start);
		map.put("end", end);
		map.put("sortOrder", sortOrder);
		map.put("sortField", sortField);
		return getSqlSession().selectList("cooperation.getPageingEntities", map);
	}
	
	public long getTotal(Map<String,String> map){
		return getSqlSession().selectOne("cooperation.getTotal",map);
	}

}
