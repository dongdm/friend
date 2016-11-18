package com.dong.friend.common.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minute4Job implements Job{
	
	Logger logger = LoggerFactory.getLogger(Minute4Job.class);

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("JobName4: {}", context.getJobDetail().getKey().getName());
		logger.info("JobName4: {}", context.getJobDetail().getKey().getGroup());
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String str = jobDataMap.getString("stringValue");
		float f = jobDataMap.getFloat("floatValue");
		logger.info("stringValue: {}", str);
		logger.info("floatValue: {}", f);
		
		JobKey key = context.getJobDetail().getKey();
		logger.info("keyValue: {}", key);
	}

}
