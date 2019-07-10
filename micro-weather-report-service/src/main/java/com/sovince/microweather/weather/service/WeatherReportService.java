package com.sovince.microweather.weather.service;

import com.sovince.microweather.weather.vo.Weather;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/4
 * Time: 21:02
 * Description:
 */
public interface WeatherReportService {
    Weather getDataByCityName(String cityName);
}
