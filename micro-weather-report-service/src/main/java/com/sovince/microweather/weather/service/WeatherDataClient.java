package com.sovince.microweather.weather.service;

import com.sovince.microweather.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/10
 * Time: 21:09
 * Description:
 */
@FeignClient("micro-weather-data-service")
@Service
public interface WeatherDataClient {

    @GetMapping("/weather/cityName/{cityName}")
    WeatherResponse getWeaherByCityName(@PathVariable("cityName") String cityName);
    //@PathVariable在这里必须指定参数不能默认

}
