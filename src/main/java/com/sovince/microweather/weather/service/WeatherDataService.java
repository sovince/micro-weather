package com.sovince.microweather.weather.service;

import com.sovince.microweather.weather.vo.WeatherResponse;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:20
 * Description:
 */
public interface WeatherDataService {
    /**
     * 根据城市id查天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);


    /**
     * 同步天气数据
     * @param cityName
     */
    void syncDataByCityName(String cityName);

}
