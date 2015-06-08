package com.bank.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bank.beans.CooperationProfit;
import com.bank.dao.ICooperationProfitDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@Repository("cooperationProfitDao")
public class CooperationProfitImpl extends GenericMyBatisDAOSupport<CooperationProfit,Long> implements ICooperationProfitDao {
	
	private static Logger log = LoggerFactory.getLogger(CooperationProfitImpl.class);
	
	@Override
	public void save(CooperationProfit entity) throws DAOException,
			CreateException {
		this.getSqlSession().insert("cooperationProfit.save", entity);
	}

	@Override
	public void update(CooperationProfit entity) throws DAOException,
			UpdateException {
		this.getSqlSession().update("cooperationProfit.update", entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException{
		this.getSqlSession().update("cooperationProfit.delete", pk);
	}

	@Override
	public CooperationProfit findByPK(Long pk) throws DAOException,
			DataNotFoundException {
		return getSqlSession().selectOne("cooperationProfit.findByPK", pk);
	}

	@Override
	public List<CooperationProfit> getAllEntities() throws DAOException {
		return null;
	}

	@Override
	public List<CooperationProfit> getPageingEntities(int pageIndex,
			int pageSize, String sortField, String sortOrder,Map map)
			throws DAOException {
		int start = pageIndex * pageSize, end = start + pageSize;
		if (!"desc".equals(sortOrder))
			sortOrder = "asc";
		map.put("start", start);
		map.put("end", end);
		map.put("sortOrder", sortOrder);
		map.put("sortField", sortField);
		return getSqlSession().selectList("cooperationProfit.getPageingEntities", map);
	}
	
	public long getTotal(Map<String,String> map){
		return getSqlSession().selectOne("cooperationProfit.getTotal",map);
	}
	
	@Override
	public Long getUnitId(Map<String,Object> map){
		try {
			return getSqlSession().selectOne("cooperationProfit.getUnitId",map);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

}
