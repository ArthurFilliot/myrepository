package com.arthur.hr.front.batch;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContext {

	@Test
	public void test() {
		 String[] springConfig  =  { "context.xml" };  
	      
	      // Creating the application context object  
	      ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	}

}
