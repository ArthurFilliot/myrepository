package com.arthur.hr.front.batch;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arthur.hr.front.batch.employees.EmployeesFeedService;

public class TestEmployeesFeedService {

	@Test
	public void test() {
		  String[] springConfig  =  { "context_front_jobs_services.xml" };  
	      
	      // Creating the application context object  
	      ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	      
	      // Creating the service bean
	      EmployeesFeedService service = (EmployeesFeedService) context.getBean("employeesFeedService");
	      
	      // Launch feed generation
	      service.generateFeed();
	}

}
