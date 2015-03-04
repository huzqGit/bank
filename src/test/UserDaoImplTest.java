package test;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.User;
import com.bank.dao.IUserDao;

public class UserDaoImplTest {
	
	//spring容器
	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
		
		//调用 userDao的方法
		User user = userDao.findUserByUsername("张三");
		
		System.out.println(user);
	}

	public void setUp() throws Exception {
		//构造spring容器
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public void testFindUserByUsername() throws Exception {
		//从spring容器中得到userDao的bean对象
		
		IUserDao userDao = (IUserDao) applicationContext.getBean("userDao");
		
		//调用 userDao的方法
		User user = userDao.findUserByUsername("张三");
		
		System.out.println(user);
		
	}

}
