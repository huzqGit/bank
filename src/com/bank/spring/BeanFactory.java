package com.bank.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class BeanFactory implements ApplicationContextAware {

	private static ApplicationContext ctx;
	
	private static WebApplicationContext webApplicationContext;
	
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		ctx=arg0;
	}
	
	public static Object getBean(String bean) {
		return ctx.getBean(bean);
	}
	
	
	public static Object getSessionBean(String arg0){
		return webApplicationContext.getBean(arg0);
	}

	public static void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		BeanFactory.webApplicationContext = webApplicationContext;
	}

	public static WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}
/*
	public static ApplicationContext getCtx() {
		return ctx;
	}

	public static void setCtx(ApplicationContext ctx) {
		BeanFactory.ctx = ctx;
	}
*/
}
