package com.arthur.hr.front.batch.employees;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

public class EmployeesFeedService {
	
	private JobLauncher launcher;
	private Job job;

	public JobLauncher getLauncher() {
		return launcher;
	}

	public void setLauncher(JobLauncher jobLauncher) {
		this.launcher = jobLauncher;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void generateFeed() {
		try {
			JobExecution execution = launcher.run(job, new JobParameters());
		      System.out.println("Exit Status : " + execution.getStatus()); 
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		} 
	}

}
