package com.bank.dao.impl;

import java.sql.Array;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.bank.beans.User;
import com.bank.common.base.BaseDaoImpl;
import com.bank.common.util.Md5Utils;
import com.bank.dao.IUserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	//由于继承SqlSessionDaoSupport通过spring容器注入会话工厂（SqlSessionFactory）

	private static final Array[] Array = null;

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
		
		User user = getSqlSession().selectOne("user.findUserByUsername", "张三");

		return user;
	}

	@Override
	public User verifyUser(User user) {
		user.setPassword(Md5Utils.hash(user.getPassword()));
		User retrunUser = getSqlSession().selectOne("user.verifyUser", user);
		if (retrunUser != null && !retrunUser.getUserId().isEmpty()){
			return retrunUser;
		} else {
			return null;
		}
		
	}

	@Override
	public User getUserById(String userId) {
		User user = getSqlSession().selectOne("user.getUserById", userId);
		return user;
	}

	public String insertUser(User user) {
		//String userId = (user.getUserId() == null || user.getUserId().toString().equals(""))? UUID.randomUUID().toString() : user.getUserId();
		//user.setUserId(userId);
		user.setPassword(Md5Utils.hash(user.getPassword()));
		getSqlSession().insert("user.insertSelective", user);
		return user.getUserId();
	}
	
	@Override
	public void updateUser(User user) {
		getSqlSession().update("user.update", user);
		
	}

	public boolean deleteUser(String userId) {
		int flag = getSqlSession().delete("user.delete", userId);
		return false;
	}

	@Override
	public List<User> loadAllUsers(@Param("key") String key, @Param("pageIndex") int pageIndex, @Param("pageSize")int pageSize,
			@Param("sortField") String sortField, @Param("sortOrder") String sortOrder) {
		int start = pageIndex * pageSize, end = start + pageSize;
		if ("desc".equals(sortOrder) == false) sortOrder = "asc";
		
		List<User> users = getSqlSession().selectList("user.loadAllUsers", new Object[]{start, end, sortField, sortOrder});
		return users;
	}



}
