package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;





import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;
import com.bank.dao.ICooperationMapper;

@Repository("cooperationDao1")
public class CooperationMapper extends SqlSessionDaoSupport implements ICooperationMapper {

	private static String namespace = "cooperation1";
	
	@Resource(name="sqlSessionFactory")    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
    }
	@Override
	public int countByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne(namespace+".countByExample", example);
		return num;
	}

	@Override
	public int deleteByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().delete(namespace+".deleteByExample", example);
		return num;
	}

	@Override
	public int insert(Cooperation record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert(namespace+".insert", record);
		return num;
	}

	@Override
	public int insertSelective(Cooperation record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert(namespace+".insertSelective", record);
		return num;
	}

	@Override
	public List<Cooperation> selectByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		List<Cooperation> cooperations = this.getSqlSession().selectList(namespace+".selectByExample", example);
		return cooperations;
	}

	@Override
	public int updateByExampleSelective(Cooperation record,
			CooperationExample example) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update(namespace+".updateByExampleSelective",map);
		return num;
	}

	@Override
	public int updateByExample(Cooperation record, CooperationExample example) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update(namespace+".updateByExample",map);
		return num;
	}

}
