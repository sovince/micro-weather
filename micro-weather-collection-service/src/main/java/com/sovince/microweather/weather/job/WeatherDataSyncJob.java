package com.sovince.microweather.weather.job;

import com.sovince.microweather.weather.service.CityDataClient;
import com.sovince.microweather.weather.service.WeatherDataService;
import com.sovince.microweather.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/3
 * Time: 21:10
 * Description:
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityDataClient cityDataClient;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<City> cityList = null;
        try {
            cityList = cityDataClient.cityList();

        } catch (Exception e) {
            logger.error("Fail to get CityList!", e);
        }
        for (City city : cityList) {
            logger.info("Weather Data Sync Job,cityName:" + city.getCityname());
            weatherDataService.syncDataByCityName(city.getCityname());//频繁测试启动 需要优化
        }
        logger.info("Weather Data Sync Job Finished!!!");
    }
}
