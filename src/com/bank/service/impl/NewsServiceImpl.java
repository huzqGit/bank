package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.News;
import com.bank.dao.INewsDao;
import com.bank.service.INewsService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("newsService")
public class NewsServiceImpl extends GenericServiceImpl<News, Long> 
	implements INewsService {
	
	@Resource
	private INewsDao newsDao;
	@Override
	public GenericDAO<News, Long> getGenericDAO() {
		// TODO Auto-generated method stub
		return newsDao;
	}
	public INewsDao getNewsDao() {
		return newsDao;
	}
	public void setNewsDao(INewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
}
