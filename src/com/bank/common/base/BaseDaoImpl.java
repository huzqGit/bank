package com.bank.common.base;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;




/**
 * BaseDao实现类   对增删改查操作进行封装
 * @author huzq 
 *
 */
public class BaseDaoImpl extends SqlSessionDaoSupport implements IBaseDao
{
	@Resource(name="sqlSessionFactory")    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	/**
	 * 添加记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void addObject(String value,Object obj)
	{
		super.getSqlSession().insert(value, obj);
	}
	
	/**
	 * 删除记录	
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void deleteObject(String value,Object obj)
	{
		super.getSqlSession().delete(value, obj);
	}
	
	/**
	 * 修改记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void updateObject(String value,Object obj)
	{
		super.getSqlSession().update(value, obj);
	}
	
	/**
	 * 查询单条记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      Object
	 */
	public Object queryObject(String value,Object obj)
	{
		return super.getSqlSession().selectOne(value, obj);
	}
	
	/**
	 * 查询列表【用于条件查询】
	 * 
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      List
	 */
	public List queryObjects(String value,Object obj)
	{
		return super.getSqlSession().selectList(value, obj);
		
	}
	
	/**
	 * 查询列表【用于无条件查询】
	 * 
	 * @param value  需要执行的语句名称
	 * @return       List
	 */
	public List queryObjects(String value)
	{
		return super.getSqlSession().selectList(value);
	}
}
