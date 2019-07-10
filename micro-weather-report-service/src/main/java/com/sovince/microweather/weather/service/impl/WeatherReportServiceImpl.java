package com.sovince.microweather.weather.service.impl;

import com.sovince.microweather.weather.service.WeatherDataClient;
import com.sovince.microweather.weather.service.WeatherReportService;
import com.sovince.microweather.weather.vo.Weather;
import com.sovince.microweather.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/4
 * Time: 21:03
 * Description:
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

//    @Autowired
//    private WeatherDataService weatherDataService;
    @Autowired
    private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityName(String cityName) {
        WeatherResponse dataByCityName = weatherDataClient.getWeaherByCityName(cityName);
        return dataByCityName.getData();
    }
}
