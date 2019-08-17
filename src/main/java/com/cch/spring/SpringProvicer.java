package com.cch.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringProvicer {
	
	private static ApplicationContext applicationContext;

	public static void init() {
		System.out.println("applicationContext init....");
		if(applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		}
	}

	public static <T> T getBean(Class<T> cls) {
		return (T) applicationContext.getBean(cls);
	}

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

}
