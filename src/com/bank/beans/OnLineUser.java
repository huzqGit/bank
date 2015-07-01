
package com.bank.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.alisoft.xplatform.asf.cache.ICache;
import com.bank.spring.BeanFactory;

public class OnLineUser implements HttpSessionBindingListener, Serializable {
	private static final long serialVersionUID = 2222982167246079922L;
	public static final String ONLINE_USER_KEY = "onlineUser_";
	private static final String MEM_CACHE_KEY = "memCache";
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private User user;
	private String curData = "";
	private String userIP = "";
	private String macAddress = "";
	private String organName;
	
	@Resource
	private ICache memCache;
	
	private static List<String> onlineUser = new ArrayList();
	

	public OnLineUser(User user) {
		this.user = user;
		this.curData = FORMAT.format(new Date());
	}

	public String getCurData() {
		return curData;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	public String getUserIP() {
		return userIP;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	@SuppressWarnings("unchecked")
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();
		ICache cache = (ICache)BeanFactory.getBean(MEM_CACHE_KEY);
		cache.put(ONLINE_USER_KEY + user.getUserId(), this, session.getMaxInactiveInterval());
		onlineUser.add(user.getUserId());
		cache.put("userCounts", onlineUser);
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		ServletContext application = session.getServletContext();

		ICache cache = (ICache)BeanFactory.getBean(MEM_CACHE_KEY);
		cache.remove(ONLINE_USER_KEY + user.getUserId());
		if(onlineUser.contains(user.getUserId())){
			onlineUser.remove(user.getUserId());
			cache.put("userCounts", onlineUser);
		}
		this.user = null;
	}

	public User getUser() {
		return user;
	}
}
