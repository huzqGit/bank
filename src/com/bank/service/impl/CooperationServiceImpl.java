package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;





import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;
import com.bank.dao.ICooperationMapper;
import com.bank.service.ICooperationService1;

@Service("cooperationService1")
public class CooperationServiceImpl implements ICooperationService1 {

	@Resource(name="cooperationDao1")
	private ICooperationMapper cooperationDao;
	
	@Override
	public int countByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		return cooperationDao.countByExample(example);
	}

	@Override
	public int deleteByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		return cooperationDao.deleteByExample(example);
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
		return cooperationDao.updateByExample(record, example);
	}

}
