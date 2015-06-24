package com.bank.utils;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;

/**
 * properties操作类<br/>
 * <b>note</b>:<br/>
 * 1)PropConfig.getPropValue(name)获取默认properties/config.properties配置<br/>
 * 2)PropConfig.getPropValueBySpring(name)获取spring配置文件的配置
 * @author zkongbai
 */
public class PropConfig {
	
	private static Properties properties;
	/**
	 * spring 加载的properties
	 */
	private static  Properties SPRING_PROPS = null;
	private static boolean isLoad = false;
	private static final String INIT_PATH = "config.properties";

	/**
	 * 读取配置文件
	 */
	static{
		init(INIT_PATH);
	}
	
	/**
	 * 恢复默认路径的初始化
	 * @author zkongbai
	 * @date 2015年4月20日  上午10:45:15
	 * @version 1.0
	 * @return
	 */
	public static synchronized boolean restoreInit(){
		return initForce(INIT_PATH);
	}
	
	/**
	 * 取properties文件中的属性值
	 * @param propName
	 * @return
	 */
	public static synchronized String getPropValue(String propName){
		return properties.getProperty(propName);
	}
	
	/**
	 * 取properties文件中的属性值，把string转化为int,如果属性值不是number的，则返回-1
	 * @param propName
	 * @return
	 */
	public static synchronized int getPropValueToInt(String propName){
		String value = properties.getProperty(propName);
		if(StringUtils.isNotBlank(value) && StringUtils.isNumeric(value)){
			return Integer.parseInt(value);
		}
		return -1;
	}
	
	/**
	 * 初始化properties文件
	 *
	 */
	private synchronized static boolean init(String path){
		System.out.println("初始化properties文件,文件路径:\t"+path);
		if(!isLoad){
			try {
				properties = new Properties();
				ClassLoader loader = PropConfig.class.getClassLoader();
				properties.load(loader.getResourceAsStream(path));
				isLoad = true;
			} catch (Exception e) {
				System.err.println("初始化properties文件失败:"+path);
				isLoad = false;
			}
		}
		return isLoad;
	}
	
	/**
	 * 强制初始化配置文件
	 * @author zkongbai
	 * @date 2015年4月20日  上午10:35:34
	 * @version 1.0
	 * @param path
	 * @return
	 */
	public static synchronized boolean initForce(String path){
		isLoad = false;
		try {
			properties = new Properties();
			ClassLoader loader = PropConfig.class.getClassLoader();
			properties.load(loader.getResourceAsStream(path));
			isLoad = true;
		} catch (Exception e) {
			System.err.println("初始化properties文件失败:"+path+"\t"+e.getMessage());
		}
		return isLoad;
	}
	
	/**
	 * spring默认加载方式
	 * @author zkongbai
	 * @date 2015年4月20日  下午12:55:28
	 * @version 1.0
	 * @param props
	 */
	public static void initBySpring(Properties props){
		SPRING_PROPS = props;
	}
	
	public static synchronized String getPropValueBySpring(String name){
		return SPRING_PROPS.getProperty(name);
	}
	
	/*
	public static void main(String args[]){
		PropConfig c = new PropConfig();	
		c.init();
		System.out.println(PropConfig.getPropValue("DEPT_ROOT_ID"));
	}
	*/
}
