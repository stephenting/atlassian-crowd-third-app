package com.fangwai.core.ssh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware {


    private static ApplicationContext applicationContext;

 
    public void setApplicationContext(ApplicationContext cnt) {
	SpringContextHolder.applicationContext = cnt;
    }

    public static ApplicationContext getApplicationContext() {
	return applicationContext;
    }


    @SuppressWarnings("unchecked")
    public static <T> T instanceOf(String name) {
	return (T)applicationContext.getBean(name);
    }

}
