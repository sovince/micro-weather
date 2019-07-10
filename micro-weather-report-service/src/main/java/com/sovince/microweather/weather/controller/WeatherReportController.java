package com.sovince.microweather.weather.controller;

import com.sovince.microweather.weather.service.CityDataClient;
import com.sovince.microweather.weather.service.WeatherReportService;
import com.sovince.microweather.weather.vo.City;
import com.sovince.microweather.weather.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/4
 * Time: 21:06
 * Description:
 */
@Controller
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityDataClient cityDataClient;

    @GetMapping("/cityName/{cityName}")
    public String getReportByCityName(@PathVariable String cityName, Model model) throws Exception {
        //部分城市查询结果是null
        Weather report = weatherReportService.getDataByCityName(cityName);
        List<City> cityList = cityDataClient.cityList();

        model.addAttribute("cityName",cityName);
        model.addAttribute("cityList",cityList);
        model.addAttribute("report",report);

        return "weather/report";
    }

}
