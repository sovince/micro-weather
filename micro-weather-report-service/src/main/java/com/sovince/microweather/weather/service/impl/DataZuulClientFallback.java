package com.sovince.microweather.weather.service.impl;

import com.sovince.microweather.weather.service.DataZuulClient;
import com.sovince.microweather.weather.vo.City;
import com.sovince.microweather.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/11
 * Time: 18:41
 * Description: 熔断回调类
 */
@Component
public class DataZuulClientFallback implements DataZuulClient {
    @Override
    public List<City> cityList() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City("UNKNOWN", "UNKNOWN", "UNKNOWN");
        cities.add(city);
        return cities;
    }

    @Override
    public WeatherResponse getWeaherByCityName(String cityName) {
        return new WeatherResponse(null,1002,"天气数据API服务不可用");
    }
}
