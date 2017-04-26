package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware {

	ApplicationContext applicationContext;

	public ApplicationContext getContext() {
		return applicationContext;
	}

	public Object getBean(String name) {
		if (applicationContext == null)
			return null;
		return applicationContext.getBean(name);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub

	}

}
