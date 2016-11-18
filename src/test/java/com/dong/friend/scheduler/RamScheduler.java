package com.dong.friend.scheduler;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import com.dong.friend.common.job.Minute4Job;



public class RamScheduler {
	
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		//the calendar will be skipped
		HolidayCalendar holidayCalendar = new HolidayCalendar();
		holidayCalendar.addExcludedDate(new Date());
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.addCalendar("holiday", holidayCalendar, false, false);
		scheduler.start();
		// define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(Minute4Job.class)
		      .withIdentity("myJob", "group1")
		      .usingJobData("stringValue", "Hello World!")
		      .usingJobData("floatValue", Float.MAX_VALUE)
		      .build();
		  
		  
		 

		  // Trigger the job to run now, and then every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("myTrigger", "group1")
		      .startNow()
		      .withSchedule(SimpleScheduleBuilder.simpleSchedule()
		          .withIntervalInSeconds(40)
		          .repeatForever())
		      .build();
		  
		 

		  // Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(job, trigger);
//		scheduler.shutdown();
		
		Thread.currentThread().sleep(Integer.MAX_VALUE);
	}

}
