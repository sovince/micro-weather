package com.sovince.microweather.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/9
 * Time: 23:08
 * Description:
 */
@FeignClient("micro-weather-city-data-server")
@Component
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
