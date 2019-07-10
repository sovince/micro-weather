package com.sovince.microweather.weather.service;

import com.sovince.microweather.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/10
 * Time: 19:42
 * Description:
 */

/**
 * 改用zuul接口 DataZuulClient
 */
@Deprecated
@FeignClient("micro-weather-city-service")
@Service
public interface CityDataClient {

    @GetMapping("/cities")
    List<City> cityList();

}
