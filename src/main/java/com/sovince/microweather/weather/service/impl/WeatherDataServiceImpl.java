package com.sovince.microweather.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sovince.microweather.weather.service.WeatherDataService;
import com.sovince.microweather.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:25
 * Description:
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "?citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "?city=" + cityName;
        return doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);//不能直接转pojo?
        WeatherResponse weatherResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();

        if (entity.getStatusCodeValue() == 200) {
            String body = entity.getBody();
            try {
                weatherResponse = objectMapper.readValue(body, WeatherResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return weatherResponse;
    }
}
