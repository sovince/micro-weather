package com.sovince.microweather.weather.controller;

import com.sovince.microweather.weather.service.CityDataService;
import com.sovince.microweather.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/10
 * Time: 18:53
 * Description:
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @RequestMapping
    public List<City> cityList() throws Exception {
        return cityDataService.listCity();
    }
}
