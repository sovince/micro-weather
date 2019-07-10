package com.sovince.microweather.weather.service;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:20
 * Description:
 */
public interface WeatherDataService {

    /**
     * 同步天气数据
     * @param cityName
     */
    void syncDataByCityName(String cityName);

}
