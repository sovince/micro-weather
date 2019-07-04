package com.sovince.microweather.weather.config;

import com.sovince.microweather.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/3
 * Time: 21:13
 * Description:
 * 天气数据同步的定时任务的配置
 */
@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail weatherDataSyncJobJobDetail() {
        return JobBuilder
                .newJob(WeatherDataSyncJob.class)
                .withIdentity("WeatherDataSyncJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger weatherDataSyncJobTrigger() {

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(3600)//
                .repeatForever();

        return TriggerBuilder
                .newTrigger()
                .forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
