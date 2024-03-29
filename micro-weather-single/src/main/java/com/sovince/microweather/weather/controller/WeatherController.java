package com.sovince.microweather.weather.controller;

import com.sovince.microweather.weather.service.WeatherDataService;
import com.sovince.microweather.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:42
 * Description:
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeaherByCityId(@PathVariable String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeaherByCityName(@PathVariable String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }
}
