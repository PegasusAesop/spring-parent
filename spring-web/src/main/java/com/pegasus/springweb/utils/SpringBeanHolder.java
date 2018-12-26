package com.pegasus.springweb.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanHolder implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		SpringBeanHolder.applicationContext=applicationContext;
	}

	public static Object getBean(String beanName) {
		
		return applicationContext.getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		
		return applicationContext.getBean(clazz);
	}
}
