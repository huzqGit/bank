package com.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.beans.News;
import com.bank.dao.INewsDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("newsDao")
public class NewsDaoImpl extends GenericMyBatisDAOSupport<News, Long> implements
		INewsDao {
	@Override
	public List<News> findByNumber(int number) {
		
		List<News> news = this.getSqlSession().selectList("news.findByNumber", number);
		return news;
	}

}
