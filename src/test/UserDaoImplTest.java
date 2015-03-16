package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.Menu;
import com.bank.beans.User;
import com.bank.dao.IMenuDao;
import com.bank.dao.IUserDao;

public class UserDaoImplTest {
	
	//spring容器
	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IMenuDao menuDao = (IMenuDao) applicationContext.getBean("menuDao");
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("key", "t");
		List<Menu> menus = menuDao.getPageingEntities(1, 2, "t.MENU_ID", "desc", paramMap);
		
//		//调用 userDao的方法
//		Menu menu = new Menu();
//		menu.setMenuDescr("test");
//		menu.setMenuUrl("www.sina.com");
//		menu.setMenuPid("0");
//		
//		menuDao.save(menu);
		
//		Menu menu = menuDao.findByPK("one");
		
		System.out.println(menus);
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
