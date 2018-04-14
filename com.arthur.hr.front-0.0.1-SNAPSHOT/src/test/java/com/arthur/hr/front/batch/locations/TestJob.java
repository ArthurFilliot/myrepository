package com.arthur.hr.front.batch.locations;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJob {

private static ApplicationContext context;
	
	@BeforeClass
	public static void init() {
		String[] springConfig  =  { "context_front_jobs.xml" };  
		context = new ClassPathXmlApplicationContext(springConfig);
	}
	
	@Test
	public void test() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
//		delete from locations where LOCATION_ID!=35;
//		update locations set country_id='XX';
//		delete from COUNTRIES where COUNTRY_ID<>'XX';
//		update countries set REGION_ID=35;
//		delete from regions where REGION_ID<>35;
//
//		select * from regions;
//		select * from countries;
//		select * from locations;
		
	      JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher"); 
	      Job job = (Job) context.getBean("integrateLocationsFeed"); 
	      JobExecution execution = jobLauncher.run(job, new JobParameters()); 
	      System.out.println("Exit Status : " + execution.getStatus()); 
	}

}
