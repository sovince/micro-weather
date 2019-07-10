package com.sovince.microweather.weather.controller;

import com.sovince.microweather.weather.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/9
 * Time: 23:11
 * Description:
 */
@RestController
public class CityController {
    @Autowired
    private CityClient cityClient;

    @GetMapping("cities")
    public String listCity(){
        return cityClient.listCity();
    }
}
