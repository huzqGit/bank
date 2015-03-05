package com.bank.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.bank.beans.User;
import com.bank.common.base.BaseDaoImpl;
import com.bank.dao.IUserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	//由于继承SqlSessionDaoSupport通过spring容器注入会话工厂（SqlSessionFactory）

	@Override
	public User findUserByUsername(String username) throws Exception {
//		// 从会话工厂中得到会话
//		SqlSession sqlSession = this.getSqlSession();
//
//		// 通过sqlSession操作数据库
//		// 第一个参数：user.xml定义的statement的id
//		// 第二个参数：输入参数
//		User user = sqlSession.selectOne("bank.findUserByUsername", "张三");
//		
//		//System.out.println(user);
//
//		// 如果和spring整合后由spring容器自动关闭sqlSession,不用人为关闭sqlSession
//		//sqlSession.close();
		
		User user = getSqlSession().selectOne("bank.findUserByUsername", "张三");

		return user;
	}

	@Override
	public boolean verifyUser(User user) {
		User user2 = getSqlSession().selectOne("verifyUser", user);
		if (user2 != null && !user2.getUserId().isEmpty()){
			return true;
		} else {
			return false;
		}
		
	}

}
