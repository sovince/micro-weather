package com.sovince.microweather.weather.service;

import com.sovince.microweather.weather.service.impl.DataZuulClientFallback;
import com.sovince.microweather.weather.vo.City;
import com.sovince.microweather.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/10
 * Time: 22:08
 * Description:
 */
@Service
@FeignClient(name="micro-weather-eureka-client-zuul",fallback= DataZuulClientFallback.class)
public interface DataZuulClient {

    /**
     * 经过gateway获取城市列表
     * @return
     */
    @GetMapping("/city/cities")
    List<City> cityList();

    /**
     * 经过gateway根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    @GetMapping("/weatherData/weather/cityName/{cityName}")
    WeatherResponse getWeaherByCityName(@PathVariable("cityName") String cityName);

}
