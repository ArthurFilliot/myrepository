package com.arthur.hr.front.batch;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContextJobsServices {

	@Test
	public void test() {
		 String[] springConfig  =  { "context_front_jobs_services.xml" };  
	      
	      // Creating the application context object  
	      ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	}

}
