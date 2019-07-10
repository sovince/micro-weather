package com.sovince.microweather.weather.service.impl;

import com.sovince.microweather.weather.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:25
 * Description:
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void syncDataByCityName(String cityName) {
        String uri = WEATHER_URI + "?city=" + cityName;
        saveWeatherData(uri);
    }

    /**
     * 数据存入redis
     * @param uri
     */
    private void saveWeatherData(String uri){
        String key = genarateKey(uri);
        //redis crud句柄
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String body = getBodyFromUri(uri);
        ops.set(key,body);
    }

    private String getBodyFromUri(String uri){
        String body = null;
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);//不能直接转pojo?
        if (entity.getStatusCodeValue() == 200) {
            body = entity.getBody();
        }
        return body;
    }

    private String genarateKey(String uri){
        return "weather:"+uri;
    }
}
