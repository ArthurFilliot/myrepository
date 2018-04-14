package com.arthur.hr.front.batch;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.oxm.xstream.XStreamMarshaller;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.endsWith("Unmarshaller")) {
			XStreamMarshaller xstream = (XStreamMarshaller)bean;
			// Finish stream configuration
			xstream.getXStream().ignoreUnknownElements();
		}
		return bean;
	}

}
