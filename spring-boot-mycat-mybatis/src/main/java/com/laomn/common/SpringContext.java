package com.laomn.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContext.applicationContext = applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	public static Object getBean(Class<?> requiredType) throws BeansException {
		return applicationContext.getBean(requiredType);
	}

	public static void autowireBean(Class<?> beanClass) throws BeansException {
		applicationContext.getAutowireCapableBeanFactory().autowire(beanClass,
				AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
	}

}
