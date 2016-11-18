package com.dong.friend.common.job;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minute2Job implements Job {
	Logger logger = LoggerFactory.getLogger(Minute2Job.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("JobName2: {}", context.getJobDetail().getKey().getName());
		logger.info("JobName2: {}", context.getJobDetail().getKey().getGroup());
	}

}
