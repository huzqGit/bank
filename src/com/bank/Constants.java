package com.bank;

public class Constants {
	public static final String SESSION_AUTH_USER = "user";
	public static final String SESSION_CURRENT_UNIT = "unit";
	public static final String USER_NAME = "userName";
	//在线用户监听.
	public static final String SESSION_ONLINEUSER="onlineUserBindingListener";
	
	/**
	 *日志级别定义
	 */
	public static final int LOG_LEAVEL_INFO = 1;
	public static final int LOG_LEAVEL_WARRING = 2;
	public static final int LOG_LEAVEL_ERROR = 3;
	
	 /**
	  * 日志类型
	  */
	public static final int LOG_TYPE_LOGIN = 1; // 登陆
	public static final int LOG_TYPE_EXIT = 2; // 退出
	public static final int LOG_TYPE_INSERT = 3; // 插入
	public static final int LOG_TYPE_DEL = 4; // 删除
	public static final int LOG_TYPE_UPDATE = 5; // 更新
	public static final int LOG_TYPE_UPLOAD = 6; // 上传
	public static final int LOG_TYPE_OTHER = 7; // 其他
	
}
