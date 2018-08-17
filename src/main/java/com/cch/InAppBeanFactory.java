package com.cch;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class InAppBeanFactory implements ApplicationContextAware{
	
	 private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.applicationContext = context;
	}
	
    public static <T> T getBean(Class<T> cls)
    {
        return (T)applicationContext.getBean(cls.getSimpleName());
    }

    public static Object getBean(String beanName)
    {
        return applicationContext.getBean(beanName);
    }

}
