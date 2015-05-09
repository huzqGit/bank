package com.bank.dao;

import java.util.List;

import com.bank.beans.News;
import com.common.dao.GenericDAO;

public interface INewsDao extends GenericDAO<News, Long> {

	public List<News> findByNumber(int number);

}
